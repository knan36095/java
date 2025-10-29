package org.dxstudio.openapi.config;

import lombok.Data;

/**
 * 应用配置
 */
@Data
public class AppConfig {

    private String gateway;
    private String withdrawToAnyWallet;
    private String withdrawToAnyWalletByCustomRate;

}
