package org.dxstudio.openapi.param;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ToMinPayWalletParam extends MerchantAPIParam{
    /**
     * 提款金额(商户默认币种)
     */
    @Min(value = 1, message = "提款金额不能少于1")
    private BigDecimal amount;

    /**
     * 币种(钱包支持币种)
     */
    private String currency;

    /**
     * 用户ID(与邮箱2选1)
     */
    private Long userId;

    /**
     * 用户邮箱(与用户ID2选1)
     */
    private String email;
}
