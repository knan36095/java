package org.dxstudio.openapi.response.digital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dxstudio.openapi.enums.PaymentOrderBizType;
import org.dxstudio.openapi.enums.PaymentOrderType;
import org.dxstudio.openapi.enums.TradeAddressTargetType;
import org.dxstudio.openapi.response.BaseResponse;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ToAnyWalletByCustomRateResponse extends BaseResponse<ToAnyWalletByCustomRateResponse.ToAnyWalletByCustomRateData> {

    @Data
    @ToString
    public static class ToAnyWalletByCustomRateData {
        /**
         * 订单号
         */
        private String orderId;

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


        /**
         * 订单币种
         */
        private String currency;
        /**
         * 用户收款币种
         */
        private String userCurrency;

        /**
         * 订单金额
         */
        private BigDecimal amount;

        /**
         * 用户实收金额 （去掉手续费）
         */
        private BigDecimal userAmount;
        /**
         * 用户应收金额
         */
        private BigDecimal userReceivableAmount;
        /**
         * 汇率
         */
        private String rate;
        /**
         * 汇率表达式
         */
        private String rateExpression;
    }
}
