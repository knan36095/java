package org.dxstudio.openapi.untils;

import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.Map;

public class HttpClientUntil {
    private static final Integer connectTimeout = 15000;
    private static final Integer requestTimeout = 30000;
    private static final Integer readTimeout = 30000;

    private static final OkHttpClient client = createUnsafeClient();

    // 创建跳过证书验证的 OkHttpClient
    private static OkHttpClient createUnsafeClient() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {}
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {}
                        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                    }
            };
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true)
                    .connectTimeout(Duration.ofMillis(connectTimeout))
                    .readTimeout(Duration.ofMillis(readTimeout))
                    .callTimeout(Duration.ofMillis(requestTimeout))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 通用 POST 请求
     *
     * @param baseUrl      请求域名
     * @param basePath      请求路径
     * @param jsonBody JSON字符串
     * @param headers  请求头（可为 null）
     * @return 响应字符串
     * @throws IOException 失败时抛出异常
     */
    public static String postJson(String baseUrl, String basePath , JSONObject jsonBody, Map<String, String> headers) throws IOException {
            RequestBody body = RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),jsonBody.toJSONString());

            Request.Builder builder = new Request.Builder().url(baseUrl+basePath).post(body);

            if (headers != null) {
                headers.forEach(builder::addHeader);
            }

            try (Response response = client.newCall(builder.build()).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response.code() +
                            ", body: " + (response.body() != null ? response.body().string() : ""));
                }
                return response.body() != null ? response.body().string() : "";
            }

    }




}
