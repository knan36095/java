package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeAddressTargetType {
    /**
     * 内部地址
     */
    INTERNAL,
    /**
     * 外部地址
     */
    EXTERNAL,
    /**
     * 用户地址
     */
    USER;
}
