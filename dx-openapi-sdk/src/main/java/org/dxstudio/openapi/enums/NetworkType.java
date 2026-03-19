package org.dxstudio.openapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NetworkType {

    /**
     * 波场  TRC20
     */
    TRON(NetworkGeneric.TRON),

    /**
     * 币安 BEP20
     */
    BSC(NetworkGeneric.ETH),

    /**
     * polygon链 ERC-20（跟以太坊的ERC20不是一回事儿 ）
     */
    POLYGON( NetworkGeneric.ETH),

    /**
     * 以太坊链 ERC20
     */
    ETHEREUM( NetworkGeneric.ETH );


    private final NetworkGeneric generic;

}
