package org.dxstudio.openapi.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.enums.PaymentOrderBizType;
import org.dxstudio.openapi.enums.PaymentOrderType;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class AnyWalletAnyMoneyReceiveResponse extends BaseResponse<AnyWalletAnyMoneyReceiveResponse.AnyWalletAnyMoneyReceiveData>{


    @Data
    @ToString
    public static class AnyWalletAnyMoneyReceiveData {
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
         * 支付地址
         */
        private String paymentUrl;

        /**
         * 公共访问密钥
         */
        private String publicKey;

    }
}
