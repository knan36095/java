package org.dxstudio.openapi.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.enums.PaymentOrderBizType;
import org.dxstudio.openapi.enums.PaymentOrderType;
import org.dxstudio.openapi.enums.TradeAddressTargetType;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ToAnyWalletResponse extends BaseResponse<ToAnyWalletResponse.ToAnyWalletData> {

    @Data
    @ToString
    public static class ToAnyWalletData {
        /**
         * 订单号
         */
        private Long orderId;

        /**
         * 商户本地用户ID
         */
        private String localUserId;

        /**
         * 商户本地订单号
         */
        private String localOrderId;

        /**
         * 订单类型
         */
        private PaymentOrderType orderType;

        /**
         * 订单业务类型
         */
        private PaymentOrderBizType orderBizType;

        /**
         * 目标类型
         */
        private TradeAddressTargetType targetType;

        /**
         * 主网类型
         */
        private String network;

        /**
         * 地址
         */
        private String address;
    }
}
