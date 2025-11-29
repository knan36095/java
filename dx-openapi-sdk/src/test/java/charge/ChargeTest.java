package charge;

import config.ApiConfig;
import org.dxstudio.openapi.config.ClientConfig;
import org.dxstudio.openapi.request.AnyWalletAnyMoneyReceiveRequest;
import org.dxstudio.openapi.request.AnyWalletFixMoneyReceiveByCustomRequest;
import org.dxstudio.openapi.request.AnyWalletFixMoneyReceiveRequest;
import org.dxstudio.openapi.request.MinPayWalletReceiveRequest;
import org.dxstudio.openapi.response.AnyWalletAnyMoneyReceiveResponse;
import org.dxstudio.openapi.response.AnyWalletFixMoneyReceiveByCustomResponse;
import org.dxstudio.openapi.response.AnyWalletFixMoneyReceiveResponse;
import org.dxstudio.openapi.response.MinPayWalletReceiveResponse;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 充值业务（代收）
 */
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

    /**
     * 创建限定金额扫码支付订单
     *
     */
    @Test
    public void AnyWalletFixMoneyReceive() {
        Client client = initClient();
        AnyWalletFixMoneyReceiveRequest request = new AnyWalletFixMoneyReceiveRequest();
        request.setKey(apiConfig.getKey());
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis()/1000));
        request.setUserCurrency("USDT");
        request.setCurrency("USDT");
        request.setAmount(new BigDecimal("10"));
        request.setLocalUserId("55");
        request.setNotifyUrl("https://www.baidu.com");
        request.setSuccessRedirectUrl("https://www.baidu.com");
        request.setIsBlockchain(true);
        AnyWalletFixMoneyReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    /**
     * 创建限定金额扫码支付订单(商户自定义汇率）
     *
     */
    @Test
    public void AnyWalletFixMoneyByCustomReceive() {
        Client client = initClient();
        AnyWalletFixMoneyReceiveByCustomRequest request = new AnyWalletFixMoneyReceiveByCustomRequest();
        request.setKey(apiConfig.getKey());
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis()/1000));
        request.setUserCurrency("USDT");
        request.setQuoteCurrency("CNY");
        request.setQuoteAmount(new BigDecimal("100"));
        request.setLocalUserId("55");
        request.setNotifyUrl("https://www.baidu.com");
        request.setSuccessRedirectUrl("https://www.baidu.com");
        request.setIsBlockchain(true);
        AnyWalletFixMoneyReceiveByCustomResponse execute = client.execute(request);
        System.out.println(execute.getData());
    }

    private Client initClient(){
        ClientConfig clientConfig =new ClientConfig();
        clientConfig.setBaseUrl(apiConfig.getBaseUrl());
        clientConfig.setSecret(apiConfig.getSecret());
        return new Client(clientConfig);
    }
}
