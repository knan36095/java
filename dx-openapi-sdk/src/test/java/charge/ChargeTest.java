package charge;

import config.ApiConfig;
import org.dxstudio.openapi.config.Config;
import org.dxstudio.openapi.request.AnyWalletAnyMoneyReceiveRequest;
import org.dxstudio.openapi.request.MinPayWalletReceiveRequest;
import org.dxstudio.openapi.response.AnyWalletAnyMoneyReceiveResponse;
import org.dxstudio.openapi.response.MinPayWalletReceiveResponse;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;

public class ChargeTest {

    private final ApiConfig apiConfig = new ApiConfig();

    /**
     * 创建minpay钱包支付订单
     *
     */
    @Test
    public void MinPayWalletReceive() {
        Client client = initClient();
        MinPayWalletReceiveRequest request = new MinPayWalletReceiveRequest();
        request.setKey(apiConfig.getKey());
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis()/1000));
        request.setAmount(new BigDecimal("10"));
        request.setCurrency("USDT");
        request.setNotifyUrl("https://www.baidu.com");
        request.setLocalUserId("55");
        request.setSuccessRedirectUrl("https://www.baidu.com");
        MinPayWalletReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    /**
     * 创建任意金额扫码支付订单
     *
     */
    @Test
    public void AnyWalletAnyMoneyReceive() {
        Client client = initClient();
        AnyWalletAnyMoneyReceiveRequest request = new AnyWalletAnyMoneyReceiveRequest();
        request.setKey(apiConfig.getKey());
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis()/1000));
        request.setUserCurrency("USDT");
        request.setCurrency("USDT");
        request.setLocalUserId("55");
        request.setNotifyUrl("https://www.baidu.com");
        request.setSuccessRedirectUrl("https://www.baidu.com");
        request.setIsBlockchain(true);
        AnyWalletAnyMoneyReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    private Client initClient(){
        Config config=new Config();
        config.setBaseUrl(apiConfig.getBaseUrl());
        config.setSecret(apiConfig.getSecret());
        return new Client(config);
    }
}
