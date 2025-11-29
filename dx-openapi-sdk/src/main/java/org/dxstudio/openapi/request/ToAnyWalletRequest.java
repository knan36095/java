package org.dxstudio.openapi.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.response.ToAnyWalletResponse;
import org.dxstudio.openapi.enums.NetworkType;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToAnyWalletRequest extends BaseRequest<ToAnyWalletResponse>{
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
     * 主网(默认支持TRON)
     */
    @NotNull(message = "主网不能为空")
    private NetworkType network = NetworkType.TRON;


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
