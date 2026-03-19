package org.dxstudio.openapi.request.fiat;

import com.alibaba.fastjson2.JSONObject;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.enums.OtcMethodType;
import org.dxstudio.openapi.request.BaseRequest;
import org.dxstudio.openapi.response.fiat.OtcPaymentResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
@EqualsAndHashCode(callSuper = true)
@Data
public class OtcPaymentRequest extends BaseRequest<OtcPaymentResponse> {

    /**
     * 提款金额(商户默认币种)
     */
    @Min(value = 1, message = "提款金额不能少于1")
    private BigDecimal amount;
    /**
     * 币种(法币)
     */
    @NotBlank(message = "提款币种不能为空")
    private String currency;

    /**
     * 收款方式  ALIPAY（支付宝）、UNIONPAY（银联卡）、WECHAT（微信）、DIGITAL_RMB（数字人民币）
     */
    @NotNull(message = "收款方式不能为空")
    private OtcMethodType method;

    /**
     * 交易速度
     */
    @NotBlank(message = "交易速度不能为空")
    private String speed;

    /**
     * 收款信息
     */
    @NotNull(message = "收款信息不能为空")
    private JSONObject paymentData;

    @Override
    public Class<OtcPaymentResponse> getResponseClass() {
        return OtcPaymentResponse.class;
    }
    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/otc/payment/create";
    }
}

