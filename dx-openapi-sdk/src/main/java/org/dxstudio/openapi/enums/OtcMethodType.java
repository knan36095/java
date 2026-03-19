package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OtcMethodType {
    ALIPAY("ALIPAY", "支付宝"),
    UNIONPAY("UNIONPAY", "银联卡"),
    WECHAT("WECHAT", "WECHAT"),
    DIGITAL_RMB("DIGITAL_RMB", "数字人民币");
    private String code;
    private String desc;
}
