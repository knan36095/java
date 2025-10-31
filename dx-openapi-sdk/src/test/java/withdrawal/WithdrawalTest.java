package withdrawal;

import config.ApiConfig;
import org.dxstudio.openapi.config.Config;
import org.dxstudio.openapi.dto.ToAnyWalletByCustomRateResponseDto;
import org.dxstudio.openapi.dto.ToAnyWalletResponseDto;
import org.dxstudio.openapi.dto.ToMinPayWalletResponseDto;
import org.dxstudio.openapi.enums.NetworkType;
import org.dxstudio.openapi.request.ToAnyWalletByCustomRateRequest;
import org.dxstudio.openapi.request.ToAnyWalletRequest;
import org.dxstudio.openapi.request.ToMinPayWalletRequest;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

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
        param.setLocalOrderId(String.valueOf(new Random().nextInt(10)));
        param.setLocalUserId("55");
        param.setEmail("knan36095@gmail.com");
        param.setAmount(new BigDecimal("10"));
        param.setCurrency("USDT");
        param.setNotifyUrl("https://merchant/callback");
        ToMinPayWalletResponseDto execute = client.execute(param);
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
        param.setLocalOrderId(String.valueOf(new Random().nextInt(10)));
        param.setLocalUserId("55");
        param.setNotifyUrl("https://merchant/callback");
        param.setNetwork(NetworkType.TRON);
        param.setAmount(new BigDecimal("10"));
        param.setCurrency("USDT");
        param.setAddress("TPutFhYUQnrRxHSmKVwjp55vgk9QY6r5nS");
        param.setIsBlockchain(true);
        ToAnyWalletResponseDto execute = client.execute(param);
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
        param.setLocalOrderId(String.valueOf(new Random().nextInt(10)));
        param.setLocalUserId("55");
        param.setNotifyUrl("https://merchant/callback");
        param.setNetwork(NetworkType.TRON);
        param.setQuoteAmount(new BigDecimal("100"));
        param.setQuoteCurrency("CNY");
        param.setCurrency("USDT");
        param.setAddress("TPutFhYUQnrRxHSmKVwjp55vgk9QY6r5nS");
        param.setIsBlockchain(true);
        param.setIsBlockchain(true);
        ToAnyWalletByCustomRateResponseDto execute = client.execute(param);
        System.out.println(execute.toString());
    }

    private  Client initClient(){
        Config config=new Config();
        config.setBaseUrl(apiConfig.getBaseUrl());
        config.setSecret(apiConfig.getSecret());
        return new Client(config);
    }
}
