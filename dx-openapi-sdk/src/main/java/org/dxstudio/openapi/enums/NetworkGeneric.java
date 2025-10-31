package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 主网分类
 */
@Getter
@AllArgsConstructor
public enum NetworkGeneric {

    /**
     * 波场链
     */
    TRON,

    /**
     * ETH兼容链
     */
    ETH;

}
