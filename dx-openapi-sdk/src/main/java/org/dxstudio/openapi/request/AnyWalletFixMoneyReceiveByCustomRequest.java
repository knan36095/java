package org.dxstudio.openapi.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.AnyWalletFixMoneyReceiveByCustomResponse;
import org.dxstudio.openapi.response.AnyWalletFixMoneyReceiveResponse;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 固定金额扫码支付请求参数 （商户自定义汇率）  7.3.2  ok
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AnyWalletFixMoneyReceiveByCustomRequest extends BaseRequest<AnyWalletFixMoneyReceiveByCustomResponse>{

    /**
     * 需要用户支付的币种(仅数字币)
     */
    @NotBlank(message = "用户支付币种不能为空")
    private String userCurrency;

    /**
     * 自定义报价币种
     */
    @NotBlank(message = "报价币种不能为空")
    private String quoteCurrency;

    /**
     * 自定义报价金额
     */
    @NotNull(message = "报价金额不能为空")
    private BigDecimal quoteAmount;

    /**
     * 过期时间戳
     */
    private Long expireSecond;

    /**
     * 链转账主网
     */
    private ArrayList<String> networkLimits;
    @Override
    public Class<AnyWalletFixMoneyReceiveByCustomResponse> getResponseClass() {
        return AnyWalletFixMoneyReceiveByCustomResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/blockchain/fixed/custom/rate/create";
    }
}
