package org.dxstudio.openapi.request;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.AnyWalletAnyMoneyReceiveResponse;
import org.dxstudio.openapi.response.MinPayWalletReceiveResponse;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
@EqualsAndHashCode(callSuper = true)
@Data
public class AnyWalletAnyMoneyReceiveRequest extends BaseRequest<AnyWalletAnyMoneyReceiveResponse>{

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

    @Override
    public Class<AnyWalletAnyMoneyReceiveResponse> getResponseClass() {
        return AnyWalletAnyMoneyReceiveResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/blockchain/any/create";
    }
}
