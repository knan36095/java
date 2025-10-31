package org.dxstudio.openapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.enums.PaymentOrderBizType;
import org.dxstudio.openapi.enums.PaymentOrderType;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class ToMinPayWalletResponseDto extends BaseResponseDto<ToMinPayWalletResponseDto.ToMinPayWalletData>{

    @Data
    @ToString
    public static class ToMinPayWalletData {
        /**
         * 订单号
         */
        private String orderId;
        /**
         * 商户本地用户ID
         */
        private String localUserId;
        /**
         * 商户本地订单ID
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
         * 收款用户ID
         */
        private Long toUserId;

    }

}
