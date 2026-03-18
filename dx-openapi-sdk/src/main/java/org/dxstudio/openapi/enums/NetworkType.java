package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NetworkType {

    /**
     * 波场
     */
    TRON(NetworkGeneric.TRON),

    /**
     * 币安
     */
    BSC(NetworkGeneric.ETH),

    /**
     * polygon链
     */
    POLYGON( NetworkGeneric.ETH),

    /**
     * ETHEREUM
     */
    ETHEREUM( NetworkGeneric.ETH );


    private final NetworkGeneric generic;

}
