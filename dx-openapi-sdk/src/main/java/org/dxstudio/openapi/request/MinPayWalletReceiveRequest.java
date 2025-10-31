package org.dxstudio.openapi.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.MinPayWalletReceiveResponse;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class MinPayWalletReceiveRequest extends BaseRequest<MinPayWalletReceiveResponse>{
    /**
     * 订单币种
     */
    @NotBlank(message = "订单币种不能为空")
    private String currency = "CNY";

    /**
     * 收款金额
     */
    @NotNull(message = "订单金额不能为空")
    @Min(value = 1, message = "收款金额最小为1")
    private BigDecimal amount;


    @Override
    public Class<MinPayWalletReceiveResponse> getResponseClass() {
        return MinPayWalletReceiveResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/internal/api/create";
    }
}
