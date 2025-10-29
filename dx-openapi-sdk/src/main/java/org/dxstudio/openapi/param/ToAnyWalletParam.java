package org.dxstudio.openapi.param;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.enums.NetworkType;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ToAnyWalletParam extends MerchantAPIParam{
    /**
     * 提款金额(商户默认币种)
     */
    @NotNull(message = "提款金额不能为空")
    @DecimalMin(value = "0", message = "金额必须大于0", inclusive = false)
    private BigDecimal amount;

    /**
     * 币种(订单币种)
     */
    @NotBlank(message = "币种不能为空")
    private String currency;


    /**
     * 主网(目前仅支持TRON)
     */
    @NotNull(message = "主网不能为空")
    private NetworkType network = NetworkType.TRON;


    @NotBlank(message = "提款地址不能为空")
    private String address;

}
