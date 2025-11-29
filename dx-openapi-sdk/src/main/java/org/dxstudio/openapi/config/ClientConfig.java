package org.dxstudio.openapi.config;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClientConfig {

    /**
     * 商户请求secret  用于sign加密
     */
    @NotBlank(message = "商户请求secret不能为空")
    private String secret;
    /**
     * 商户请求网关
     */
    private String baseUrl;

}
