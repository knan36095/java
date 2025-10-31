package org.dxstudio.openapi.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.dxstudio.openapi.dto.ToMinPayWalletResponseDto;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ToMinPayWalletRequest extends BaseRequest<ToMinPayWalletResponseDto> {

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
    public Class<ToMinPayWalletResponseDto> getResponseClass() {
        return ToMinPayWalletResponseDto.class;
    }
    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/pay/wallet/create";
    }
}
