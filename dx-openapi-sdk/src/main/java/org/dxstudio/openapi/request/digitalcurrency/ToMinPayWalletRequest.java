package org.dxstudio.openapi.request.digitalcurrency;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.request.BaseRequest;
import org.dxstudio.openapi.response.digitalcurrency.ToMinPayWalletResponse;

import java.math.BigDecimal;
/**
 * 提款至MINPAY钱包请求参数  5.2.1 ok
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ToMinPayWalletRequest extends BaseRequest<ToMinPayWalletResponse> {

    /**
     * 提款金额(商户默认币种)
     */
    @Min(value = 1, message = "提款金额不能少于1")
    private BigDecimal amount;
    /**
     * 币种(钱包支持币种)
     */
    @NotBlank(message = "提款币种不能为空")
    private String currency;

    /**
     * 用户ID(与邮箱2选1)
     */
    private Long userId;

    /**
     * 用户邮箱(与用户ID2选1)
     */
    private String email;

    @Override
    public Class<ToMinPayWalletResponse> getResponseClass() {
        return ToMinPayWalletResponse.class;
    }
    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/pay/wallet/create";
    }
}
