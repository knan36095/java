package org.dxstudio.openapi.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.MinPayWalletReceiveResponse;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 创建MINPAY钱包支付订单 请求参数  7.1.1 ok
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MinPayWalletReceiveRequest extends BaseRequest<MinPayWalletReceiveResponse>{
    /**
     * 订单币种
     */
    @NotBlank(message = "订单币种不能为空")
    private String currency ;

    /**
     * 收款金额
     */
    @NotNull(message = "订单金额不能为空")
    @Min(value = 1, message = "收款金额最小为1")
    private BigDecimal amount;

    /**
     * 过期时间戳
     */
    private Long expireSecond;

    @Override
    public Class<MinPayWalletReceiveResponse> getResponseClass() {
        return MinPayWalletReceiveResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/receive/internal/api/create";
    }
}
