package org.dxstudio.openapi.sdk.withdrawal;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.dxstudio.openapi.config.AppConfig;
import org.dxstudio.openapi.param.MerchantAPIParam;
import org.dxstudio.openapi.param.ToAnyWalletByCustomRate;
import org.dxstudio.openapi.param.ToAnyWalletParam;
import org.dxstudio.openapi.config.HttpClient;

import org.dxstudio.openapi.param.ToMinPayWalletParam;
import org.dxstudio.openapi.untils.SignUtil;
import org.dxstudio.openapi.dto.UserWithdrawalDto;

import java.io.IOException;


@RequiredArgsConstructor
public class UserWithdrawalService {

    private final AppConfig appConfig;

    private final HttpClient httpClient;

   /*
    用户提款至任意钱包 文档 5.11
    */
    @SneakyThrows
    public UserWithdrawalDto toAnyWallet(ToAnyWalletParam toAnyWalletParam) {
        // 配置校验
        verifyConfiguration(toAnyWalletParam, httpClient, appConfig);

        //组装请求参数
        JSONObject jsonObject = processingParam(toAnyWalletParam);
        String post = httpClient.post(appConfig.getGateway(), appConfig.getWithdrawToAnyWallet(), jsonObject.toJSONString(), null);
        // 响应校验
        if (post == null || post.trim().isEmpty()) {
            throw new IOException("Received empty response from server");
        }
        try {
            return JSONObject.parseObject(post, UserWithdrawalDto.class);
        } catch (Exception e) {
            throw new IOException("Failed to parse response to ToAnyWalletDto: " + post, e);
        }
    }



   /*
    用户提款至任意钱包（自定义汇率）文档 5.12
    注：需商户登录后台设置报价币种汇率
    */
    @SneakyThrows
    public UserWithdrawalDto toAnyWalletByCustomRate(ToAnyWalletByCustomRate toAnyWalletByCustomRate) {
        // 配置校验
        verifyConfiguration(toAnyWalletByCustomRate, httpClient, appConfig);
        //组装请求参数
        JSONObject jsonObject = processingParam(toAnyWalletByCustomRate);
        String post = httpClient.post(appConfig.getGateway(), appConfig.getWithdrawToAnyWalletByCustomRate(), jsonObject.toJSONString(), null);
        // 响应校验
        if (post == null || post.trim().isEmpty()) {
            throw new IOException("Received empty response from server");
        }
        try {
            return JSONObject.parseObject(post, UserWithdrawalDto.class);
        } catch (Exception e) {
            throw new IOException("Failed to parse response to ToAnyWalletDto: " + post, e);
        }

    }

    /*
    用户提款至任意钱包（自定义汇率）文档 5.12
    注：需商户登录后台设置报价币种汇率
    */
    @SneakyThrows
    public void toMinPayWallet(ToMinPayWalletParam toMinPayWalletParam){

    }

    private void verifyConfiguration(MerchantAPIParam merchantAPIParam, HttpClient httpClient, AppConfig appConfig) {
        if (merchantAPIParam == null) {
            throw new IllegalArgumentException("toAnyWalletParam cannot be null");
        }
        if (httpClient == null) {
            throw new IllegalStateException("httpClient is not initialized");
        }
        if (appConfig == null) {
            throw new IllegalStateException("appConfig is not initialized");
        }

    }

    private JSONObject processingParam(MerchantAPIParam merchantAPIParam) {
        String jsonString = JSON.toJSONString(merchantAPIParam);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String sign = SignUtil.getSign(jsonObject, merchantAPIParam.getSecret());
        jsonObject.put("sign", sign);
        return jsonObject;
    }
}
