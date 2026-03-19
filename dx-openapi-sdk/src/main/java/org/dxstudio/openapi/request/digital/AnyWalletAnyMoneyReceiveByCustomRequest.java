package org.dxstudio.openapi.request.digital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.request.BaseRequest;
import org.dxstudio.openapi.response.digital.AnyWalletAnyMoneyReceiveByCustomResponse;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 任意金额扫码支付请求参数 （商户自定义汇率）  7.2.2  ok
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AnyWalletAnyMoneyReceiveByCustomRequest extends BaseRequest<AnyWalletAnyMoneyReceiveByCustomResponse> {

    /**
     * 订单计价币种
     */
    @NotBlank(message = "订单币种不能为空")
    private String currency;

    /**
     * 需要用户支付的币种
     */
    @NotBlank(message = "用户支付币种不能为空")
    private String userCurrency;

    /**
     * 用户预计支付金额
     */
    private BigDecimal amount;

    /**
     * 过期时间戳
     */
    private Long expireSecond;

    /**
     * 链转账主网
     */
    private ArrayList<String> networkLimits;
    @Override
    public Class<AnyWalletAnyMoneyReceiveByCustomResponse> getResponseClass() {
        return AnyWalletAnyMoneyReceiveByCustomResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/blockchain/any/custom/rate/create";
    }
}
