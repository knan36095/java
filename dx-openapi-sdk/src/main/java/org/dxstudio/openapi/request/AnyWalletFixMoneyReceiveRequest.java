package org.dxstudio.openapi.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.AnyWalletAnyMoneyReceiveResponse;
import org.dxstudio.openapi.response.AnyWalletFixMoneyReceiveResponse;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 固定金额扫码支付请求参数 （市场汇率）7.3.1 ok
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AnyWalletFixMoneyReceiveRequest extends BaseRequest<AnyWalletFixMoneyReceiveResponse>{

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
     * 订单计价金额
     */
    @NotNull(message = "订单金额不能为空")
    @DecimalMin(value = "1", message = "收款金额最小为1")
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
    public Class<AnyWalletFixMoneyReceiveResponse> getResponseClass() {
        return AnyWalletFixMoneyReceiveResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/blockchain/fixed/create";
    }
}
