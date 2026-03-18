package org.dxstudio.openapi.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.ToAnyWalletResponse;
import org.dxstudio.openapi.enums.NetworkType;

import java.math.BigDecimal;

/**
 * 提款数字币至任意钱包 （市场汇率） 5.1.1 ok
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ToAnyWalletRequest extends BaseRequest<ToAnyWalletResponse> {
    /**
     * 订单金额
     */
    @NotNull(message = "订单金额金额不能为空")
    @DecimalMin(value = "0", message = "金额必须大于0", inclusive = false)
    private BigDecimal amount;

    @NotBlank(message = "用户收款币种不能为空")
    private String userCurrency;
    /**
     * 币种(订单币种)
     */
    @NotBlank(message = "币种不能为空")
    private String currency;
    /**
     * 主网(目前仅支持 TRON、BSC、POLYGON、ETHEREUM)
     */
    @NotNull(message = "主网不能为空")
    private NetworkType network ;

    @NotBlank(message = "提款地址不能为空")
    private String address;

    @Override
    public Class<ToAnyWalletResponse> getResponseClass() {
        return ToAnyWalletResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/pay/blockchain/create";
    }
}
