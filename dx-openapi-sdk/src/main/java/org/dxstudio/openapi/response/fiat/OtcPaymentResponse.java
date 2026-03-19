package org.dxstudio.openapi.response.fiat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.response.BaseResponse;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class OtcPaymentResponse extends BaseResponse<OtcPaymentResponse.OtcPaymentResponseData> {
    @Data
    @ToString
    public static class OtcPaymentResponseData {
        /**
         * 订单号
         */
        private String orderId;
        /**
         * 商户本地订单号
         */
        private String localOrderId;
    }
}
