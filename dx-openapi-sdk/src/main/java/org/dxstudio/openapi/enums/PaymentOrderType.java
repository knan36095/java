package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 支付订单类型
 */
@Getter
@AllArgsConstructor
public enum PaymentOrderType {

    /**
     * 支付订单
     */
    PAYMENT(0,"支付订单"),

    /**
     * 提款订单
     */
    WITHDRAW(1,"提款订单");

    final int code;
    final String des;


}
