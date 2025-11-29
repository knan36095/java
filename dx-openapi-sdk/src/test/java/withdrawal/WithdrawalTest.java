package withdrawal;

import apiconfig.ApiConfig;
import org.dxstudio.openapi.config.ClientConfig;
import org.dxstudio.openapi.response.ToAnyWalletByCustomRateResponse;
import org.dxstudio.openapi.response.ToAnyWalletResponse;
import org.dxstudio.openapi.response.ToMinPayWalletResponse;
import org.dxstudio.openapi.enums.NetworkType;
import org.dxstudio.openapi.request.ToAnyWalletByCustomRateRequest;
import org.dxstudio.openapi.request.ToAnyWalletRequest;
import org.dxstudio.openapi.request.ToMinPayWalletRequest;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;
/**
 * 提现业务（代付）
 */
public class WithdrawalTest {

    private final ApiConfig apiConfig = new ApiConfig();


    /**
     * 提款至MinPay钱包
     */
    @Test
    public void toMinPayWallet() {
        Client client = initClient();
        ToMinPayWalletRequest param = new ToMinPayWalletRequest();
        param.setKey(apiConfig.getKey());
        param.setLocalOrderId(String.valueOf(new Random().nextInt(10000)));
        param.setLocalUserId("55");
        param.setEmail("knan36095@gmail.com");
        param.setAmount(new BigDecimal("10"));
        param.setCurrency("USDT");
        param.setNotifyUrl("https://merchant/callback");
        ToMinPayWalletResponse execute = client.execute(param);
        System.out.println(execute.toString());
    }

    /**
     * 提款至任意钱包
     */
    @Test
    public void toAnyWallet() {
        Client client = initClient();
        ToAnyWalletRequest param = new ToAnyWalletRequest();
        param.setKey(apiConfig.getKey());
        param.setLocalOrderId(String.valueOf(new Random().nextInt(10000)));
        param.setLocalUserId("55");
        param.setNotifyUrl("https://merchant/callback");
        param.setNetwork(NetworkType.TRON);
        param.setAmount(new BigDecimal("10"));
        param.setCurrency("USDT");
        param.setAddress("TPutFhYUQnrRxHSmKVwjp55vgk9QY6r5nS");
        param.setIsBlockchain(true);
        ToAnyWalletResponse execute = client.execute(param);
        System.out.println(execute.toString());
    }


    /**
     * 提款至任意钱包(商户自定义汇率）
     */
    @Test
    public void toAnyWalletByCustomRate() {
        Client client = initClient();
        ToAnyWalletByCustomRateRequest param = new ToAnyWalletByCustomRateRequest();
        param.setKey(apiConfig.getKey());
        param.setLocalOrderId(String.valueOf(new Random().nextInt(10000)));
        param.setLocalUserId("55");
        param.setNotifyUrl("https://merchant/callback");
        param.setNetwork(NetworkType.TRON);
        param.setQuoteAmount(new BigDecimal("100"));
        param.setQuoteCurrency("CNY");
        param.setCurrency("USDT");
        param.setAddress("TPutFhYUQnrRxHSmKVwjp55vgk9QY6r5nS");
        param.setIsBlockchain(true);
        param.setIsBlockchain(true);
        ToAnyWalletByCustomRateResponse execute = client.execute(param);
        System.out.println(execute.toString());
    }

    private  Client initClient(){
        ClientConfig clientConfig =new ClientConfig();
        clientConfig.setBaseUrl(apiConfig.getBaseUrl());
        clientConfig.setSecret(apiConfig.getSecret());
        return new Client(clientConfig);
    }
}
