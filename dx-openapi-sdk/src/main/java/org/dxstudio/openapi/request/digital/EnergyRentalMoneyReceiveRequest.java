package org.dxstudio.openapi.request.digital;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dxstudio.openapi.enums.Period;
import org.dxstudio.openapi.request.BaseRequest;
import org.dxstudio.openapi.response.digital.EnergyRentalMoneyReceiveResponse;

import java.math.BigDecimal;

/**
 * 能量代理创建订单
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnergyRentalMoneyReceiveRequest extends BaseRequest<EnergyRentalMoneyReceiveResponse> {
    /**
     * 能量数量
     */
    @NotNull(message = "能量数量不能为空")
    private Integer energy ;

    /**
     * 收款金额
     */
    @NotNull(message = "租赁时效")
    private Period period;
    /**
     * 租赁地址
     */
    @NotBlank(message = "租赁地址不能为空")
    private String address;

    @Override
    public Class<EnergyRentalMoneyReceiveResponse> getResponseClass() {
        return EnergyRentalMoneyReceiveResponse.class;
    }

    @Override
    public String getBasePath() {
        return "/wallet-trade-merchant/v1/func/tron/energy/create";
    }
}
