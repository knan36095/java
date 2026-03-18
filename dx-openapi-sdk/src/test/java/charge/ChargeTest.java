package charge;

import org.dxstudio.openapi.config.ClientConfig;
import org.dxstudio.openapi.request.digitalcurrency.AnyWalletAnyMoneyReceiveRequest;
import org.dxstudio.openapi.request.digitalcurrency.AnyWalletFixMoneyReceiveByCustomRequest;
import org.dxstudio.openapi.request.digitalcurrency.AnyWalletFixMoneyReceiveRequest;
import org.dxstudio.openapi.request.digitalcurrency.MinPayWalletReceiveRequest;
import org.dxstudio.openapi.response.digitalcurrency.AnyWalletAnyMoneyReceiveResponse;
import org.dxstudio.openapi.response.digitalcurrency.AnyWalletFixMoneyReceiveByCustomResponse;
import org.dxstudio.openapi.response.digitalcurrency.AnyWalletFixMoneyReceiveResponse;
import org.dxstudio.openapi.response.digitalcurrency.MinPayWalletReceiveResponse;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 充值业务（代收）
 */
public class ChargeTest {

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
     * 创建minpay钱包支付订单
     *
     */
    @Test
    public void MinPayWalletReceive() {
        MinPayWalletReceiveRequest request = new MinPayWalletReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis()/1000));
        request.setAmount(new BigDecimal("10"));
        request.setCurrency("USDT");
        request.setNotifyUrl("http://conan.test/notify");
        request.setLocalUserId("55");
        request.setIsBlockchain(true);
        MinPayWalletReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    /**
     * 创建任意金额扫码支付订单
     *
     */
    @Test
    public void AnyWalletAnyMoneyReceive() {
        AnyWalletAnyMoneyReceiveRequest request = new AnyWalletAnyMoneyReceiveRequest();
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
        AnyWalletFixMoneyReceiveRequest request = new AnyWalletFixMoneyReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis()/1000));
        request.setUserCurrency("USDT");
        request.setCurrency("CNY");
        request.setAmount(new BigDecimal("100"));
        request.setLocalUserId("55");
        request.setNotifyUrl("http://127.0.0.1:8080/merchant-demo/notify");
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
        AnyWalletFixMoneyReceiveByCustomRequest request = new AnyWalletFixMoneyReceiveByCustomRequest();
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

}
