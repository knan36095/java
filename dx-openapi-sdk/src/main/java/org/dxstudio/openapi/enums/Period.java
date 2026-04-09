package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租赁时效
 */
@Getter
@AllArgsConstructor
public enum Period {

    /**
     * _1H
     * _1D
     * _3D
     * 30D
     */
    _1H("_1H", "1小时"),
    _1D("_1D", "1天"),
    _3D("_3D", "3天"),
    _30D("_30D", "30天");
    private String code;
    private String desc;
    public static Period getByCode(String code) {
        for (Period value : Period.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }
}
