package org.dxstudio.openapi.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.ToAnyWalletByCustomRateResponse;
import org.dxstudio.openapi.enums.NetworkType;

import java.math.BigDecimal;

/**
 * 提款数字币至任意钱包 （商户自定义汇率） 5.1.2 ok
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ToAnyWalletByCustomRateRequest extends BaseRequest<ToAnyWalletByCustomRateResponse>{

    /**
     * 订单账币种不能为空
     */
    @NotBlank(message = "订单账币种不能为空")
    private String currency;

    /**
     * 主网(目前仅支持 TRON、BSC、POLYGON、ETHEREUM)
     */
    @NotNull(message = "主网不能为空")
    private NetworkType network;


    @NotBlank(message = "提款地址不能为空")
    private String address;

    /**
     * 订单报价币种
     */
    @NotBlank(message = "订单计价币种不能为空")
    private String quoteCurrency;

    /**
     * 报价金额
     */
    @NotNull(message = "报价金额不能为空")
    @DecimalMin(value = "0", message = "金额必须大于0", inclusive = false)
    private BigDecimal quoteAmount;

    @Override
    public Class<ToAnyWalletByCustomRateResponse> getResponseClass() {
        return ToAnyWalletByCustomRateResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/pay/blockchain/custom/rate/create";
    }
}
