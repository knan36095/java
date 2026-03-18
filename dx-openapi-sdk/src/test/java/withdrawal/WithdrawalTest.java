package withdrawal;

import org.dxstudio.openapi.config.ClientConfig;
import org.dxstudio.openapi.response.digitalcurrency.ToAnyWalletByCustomRateResponse;
import org.dxstudio.openapi.response.digitalcurrency.ToAnyWalletResponse;
import org.dxstudio.openapi.response.digitalcurrency.ToMinPayWalletResponse;
import org.dxstudio.openapi.enums.NetworkType;
import org.dxstudio.openapi.request.digitalcurrency.ToAnyWalletByCustomRateRequest;
import org.dxstudio.openapi.request.digitalcurrency.ToAnyWalletRequest;
import org.dxstudio.openapi.request.digitalcurrency.ToMinPayWalletRequest;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;
/**
 * 提现业务（代付）
 */
public class WithdrawalTest {

    /**
     * 商户请求网关域名
     */
    private  final String baseUrl = "https://api.wallet-dev.com";
    /**
     * 商户api请求 key 用于识别商户身份
     */
    private  final String key = "9yUreYgTRtit39Dy";
    /**
     * 商户api请求secret  用于sign加密
     */
    private  final String secret = "D2PQPllGEBOV4mcMxoKTM7foVpzqrjIx";

    private final ClientConfig clientConfig = new ClientConfig(key, secret, baseUrl);

    private final Client client = new Client(clientConfig);


    /**
     * 提款至MinPay钱包
     */
    @Test
    public void toMinPayWallet() {

        ToMinPayWalletRequest param = new ToMinPayWalletRequest();
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
        ToAnyWalletRequest param = new ToAnyWalletRequest();
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
        ToAnyWalletByCustomRateRequest param = new ToAnyWalletByCustomRateRequest();
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


}
