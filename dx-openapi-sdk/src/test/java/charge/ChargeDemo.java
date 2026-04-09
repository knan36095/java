package charge;

import com.alibaba.fastjson2.JSONObject;
import org.dxstudio.openapi.config.ClientConfig;
import org.dxstudio.openapi.enums.OtcMethodType;
import org.dxstudio.openapi.enums.Period;
import org.dxstudio.openapi.request.digital.*;
import org.dxstudio.openapi.request.fiat.CashMoneyReceiveRequest;
import org.dxstudio.openapi.request.fiat.OtcPaymentRequest;
import org.dxstudio.openapi.response.digital.*;
import org.dxstudio.openapi.response.fiat.CashMoneyReceiveResponse;
import org.dxstudio.openapi.response.fiat.OtcPaymentResponse;
import org.dxstudio.openapi.sdk.Client;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 充值业务（代收）
 */
public class ChargeDemo {

    /**
     * 商户请求网关域名
     */
    private final String baseUrl = "https://api.wallet-dev.com";
    /**
     * 商户api请求 key 用于识别商户身份
     */
    private final String key = "9yUreYgTRtit39Dy";
    /**
     * 商户api请求secret  用于sign加密
     */
    private final String secret = "D2PQPllGEBOV4mcMxoKTM7foVpzqrjIx";

    private final ClientConfig clientConfig = new ClientConfig(key, secret, baseUrl);

    private final Client client = new Client(clientConfig);

    /**
     * 创建minpay钱包支付订单   文档 7.1.1
     */
    @Test
    public void MinPayWalletReceive() {
        MinPayWalletReceiveRequest request = new MinPayWalletReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setAmount(new BigDecimal("10"));
        request.setCurrency("USDT");
        request.setNotifyUrl("http://conan.test/notify");
        request.setLocalUserId("55");
        MinPayWalletReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    /**
     * 创建任意金额扫码支付订单（市场汇率）  文档 7.2.1
     */
    @Test
    public void AnyWalletAnyMoneyReceive() {
        AnyWalletAnyMoneyReceiveRequest request = new AnyWalletAnyMoneyReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setUserCurrency("USDT");
        request.setCurrency("CNY");
        request.setLocalUserId("55");
        request.setNotifyUrl("http://conan.test/notify");
        request.setIsBlockchain(true);
        AnyWalletAnyMoneyReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }


    /**
     * 创建任意金额扫码支付订单（商户自定义汇率）  文档 7.2.2
     */
    @Test
    public void AnyWalletAnyMoneyReceiveByCustom() {
        AnyWalletAnyMoneyReceiveByCustomRequest request = new AnyWalletAnyMoneyReceiveByCustomRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setUserCurrency("USDT");
        request.setCurrency("CNY");
        request.setLocalUserId("55");
        request.setNotifyUrl("http://conan.test/notify");
        request.setIsBlockchain(true);
        AnyWalletAnyMoneyReceiveByCustomResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    /**
     * 创建限定金额扫码支付订单 （市场汇率）文档 7.3.1
     */
    @Test
    public void AnyWalletFixMoneyReceive() {
        AnyWalletFixMoneyReceiveRequest request = new AnyWalletFixMoneyReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setUserCurrency("USDT");
        request.setCurrency("CNY");
        request.setAmount(new BigDecimal("100"));
        request.setLocalUserId("55");
        request.setNotifyUrl("http://conan.test/notify");
        request.setIsBlockchain(true);
        AnyWalletFixMoneyReceiveResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    /**
     * 创建限定金额扫码支付订单(商户自定义汇率） 文档 7.3.2
     */
    @Test
    public void AnyWalletFixMoneyByCustomReceive() {
        AnyWalletFixMoneyReceiveByCustomRequest request = new AnyWalletFixMoneyReceiveByCustomRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setUserCurrency("USDT");
        request.setQuoteCurrency("CNY");
        request.setQuoteAmount(new BigDecimal("100"));
        request.setLocalUserId("55");
        request.setNotifyUrl("http://conan.test/notify");
        request.setIsBlockchain(true);
        AnyWalletFixMoneyReceiveByCustomResponse execute = client.execute(request);
        System.out.println(execute.getData());
    }

    /**
     * 创建法币支付订单  文档 8.1.2
     */
    @Test
    public void CashMoneyReceiveRequest() {
        CashMoneyReceiveRequest request = new CashMoneyReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setCurrency("CNY");
        request.setAmount(new BigDecimal("100"));
        request.setLocalUserId("55");
        request.setNotifyUrl("http://conan.test/notify");
        request.setChannelCode("tencentest1");
        CashMoneyReceiveResponse execute = client.execute(request);
        System.out.println(execute.getData());
    }

    /**
     * 创建能量代理单子
     */
    @Test
    public void EnergyRentalMoneyReceive() {
        EnergyRentalMoneyReceiveRequest request = new EnergyRentalMoneyReceiveRequest();
        request.setLocalOrderId(String.valueOf(System.currentTimeMillis() / 1000));
        request.setLocalUserId("55");
        request.setEnergy(64000);
        request.setNotifyUrl("http://conan.test/notify");
        request.setPeriod(Period.getByCode("_1D"));
        EnergyRentalMoneyReceiveResponse execute = client.execute(request);
        System.out.println(execute.getData());
    }
}
