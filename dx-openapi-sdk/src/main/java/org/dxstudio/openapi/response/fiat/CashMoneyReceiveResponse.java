package org.dxstudio.openapi.response.fiat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.response.BaseResponse;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CashMoneyReceiveResponse extends BaseResponse<CashMoneyReceiveResponse.CashMoneyReceiveResponseData> {
    @Data
    @ToString
    public static class CashMoneyReceiveResponseData {
        /**
         * 订单号
         */
        private String orderId;
        /**
         * 商户本地订单号
         */
        private String localOrderId;

        /**
         * 支付链接地址
         */
        private String uiUrl;
    }
}
