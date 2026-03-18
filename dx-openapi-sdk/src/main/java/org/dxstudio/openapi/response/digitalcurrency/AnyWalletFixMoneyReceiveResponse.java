package org.dxstudio.openapi.response.digitalcurrency;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.enums.PaymentOrderBizType;
import org.dxstudio.openapi.enums.PaymentOrderType;
import org.dxstudio.openapi.response.BaseResponse;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class AnyWalletFixMoneyReceiveResponse extends BaseResponse<AnyWalletFixMoneyReceiveResponse.AnyWalletFixMoneyReceiveData> {


    @Data
    @ToString
    public static class AnyWalletFixMoneyReceiveData {
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

        /**
         * 订单币种
         */
        private String currency;
        /**
         * 用户支付币种
         */
        private String userCurrency;

        /**
         * 订单金额
         */
        private BigDecimal amount;
        /**
         * 用户应付金额
         */
        private BigDecimal userReceivableAmount;
        /**
         * 汇率
         */
        private  String rate;
        /**
         * 汇率表达式
         */
        private  String rateExpression;
    }
}
