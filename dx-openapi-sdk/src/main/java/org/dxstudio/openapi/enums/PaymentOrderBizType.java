package org.dxstudio.openapi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 支付订单业务类型
 */
@Getter
@AllArgsConstructor
public enum PaymentOrderBizType {

    /**
     * 点付钱包扫码支付
     */
    PAYMENT_WALLET_SCAN(0),

    /**
     * 数字币绑定地址直充
     */
    PAYMENT_TRANSFER(1),

    /**
     * 数字币任意金额扫码支付
     */
    PAYMENT_ANY_DIGITAL_SCAN(2),

    /**
     * 提款至点付钱包
     */
    WITHDRAW_WALLET(3),
    
    /**
     * 提款数字币至任意钱包
     */
    WITHDRAW_ANY_DIGITAL_WALLET(4),

    /**
     * 数字币限定金额扫码支付
     */
    PAYMENT_FIXED_DIGITAL_SCAN(5),

    /**
     * 批量代付
     */
    BATCH_PAY(20),

    /**
     * TRX/USDT自动兑换
     */
    AUTO_EXCHANGE_TRX_USDT(21);


    final int code;

}
