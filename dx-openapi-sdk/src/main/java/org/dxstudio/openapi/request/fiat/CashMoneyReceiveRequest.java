package org.dxstudio.openapi.request.fiat;

import com.alibaba.fastjson2.JSONObject;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.enums.OtcMethodType;
import org.dxstudio.openapi.request.BaseRequest;
import org.dxstudio.openapi.response.fiat.CashMoneyReceiveResponse;
import org.dxstudio.openapi.response.fiat.OtcPaymentResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 创建法币支付订单 8.1.2 ok
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CashMoneyReceiveRequest extends BaseRequest<CashMoneyReceiveResponse> {

    /**
     * 订单金额
     */
    @Min(value = 1, message = "订单金额不能少于1")
    private BigDecimal amount;
    /**
     * 币种(法币)
     */
    @NotBlank(message = "币种不能为空")
    private String currency;

    /**
     * 渠道编码
     */
    @NotBlank(message = "渠道编码不能为空")
    private String channelCode;

    /**
     *  商户本地用户真实姓名
     */
    private String localUserRealName;
    @Override
    public Class<CashMoneyReceiveResponse> getResponseClass() {
        return CashMoneyReceiveResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/cash/payment/create";
    }
}