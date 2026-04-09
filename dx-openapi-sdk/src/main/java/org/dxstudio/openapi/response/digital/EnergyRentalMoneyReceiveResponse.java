package org.dxstudio.openapi.response.digital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.response.BaseResponse;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class EnergyRentalMoneyReceiveResponse  extends BaseResponse<EnergyRentalMoneyReceiveResponse.EnergyRentalMoneyReceiveData> {

    @Data
    @ToString
    public static class EnergyRentalMoneyReceiveData {

        private String orderId;
        private BigDecimal feeAmount;
        private String feeCurrency;
    }
}
