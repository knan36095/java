package org.dxstudio.openapi.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.dto.ToAnyWalletByCustomRateResponseDto;
import org.dxstudio.openapi.dto.ToAnyWalletResponseDto;
import org.dxstudio.openapi.enums.NetworkType;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ToAnyWalletByCustomRateRequest extends BaseRequest<ToAnyWalletByCustomRateResponseDto>{

    /**
     * 提款到账币种(钱包支持币种)
     */
    @NotNull(message = "提款到账币种不能为空")
    private String currency;

    /**
     * 主网(目前仅支持TRON)
     */
    @NotNull(message = "主网不能为空")
    private NetworkType network = NetworkType.TRON;


    @NotBlank(message = "提款地址不能为空")
    private String address;

    /**
     * 订单报价币种
     */
    @NotBlank(message = "订单计价币种不能为空")
    private String quoteCurrency;

    /**
     * 报价金额
     */
    @NotNull(message = "报价金额不能为空")
    @DecimalMin(value = "0", message = "金额必须大于0", inclusive = false)
    private BigDecimal quoteAmount;

    @Override
    public Class<ToAnyWalletByCustomRateResponseDto> getResponseClass() {
        return ToAnyWalletByCustomRateResponseDto.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/pay/blockchain/custom/rate/create";
    }
}
