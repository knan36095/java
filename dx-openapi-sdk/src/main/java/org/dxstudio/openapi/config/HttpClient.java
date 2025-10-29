package org.dxstudio.openapi.config;

import okhttp3.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class HttpClient {

    private Integer connectTimeout = 15000;

    private Integer requestTimeout = 30000;

    private Integer readTimeout = 30000;

    private final OkHttpClient client;

    public HttpClient() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofMillis(connectTimeout))
                .readTimeout(Duration.ofMillis(requestTimeout))
                .callTimeout(Duration.ofMillis(readTimeout))
                .build();
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
    public  String post(String baseUrl,String basePath ,String jsonBody, Map<String, String> headers) throws IOException {
            RequestBody body = RequestBody.create(
                    jsonBody, MediaType.parse("application/json; charset=utf-8"));

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
