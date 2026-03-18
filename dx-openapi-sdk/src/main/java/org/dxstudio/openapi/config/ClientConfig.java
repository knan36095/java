package org.dxstudio.openapi.config;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
public class ClientConfig {
    /**
     * 商户api请求 key 用于识别商户身份
     */
    @NotBlank(message = "商户api请求 key不能为空")
    private String key;

    /**
     * 商户请求secret  用于sign加密
     */
    @NotBlank(message = "商户请求secret不能为空")
    private String secret;

    /**
     * 商户请求网关
     */
    @NotBlank(message = "商户请求网关不能为空")
    private String baseUrl;

    public ClientConfig(String key, String secret, String baseUrl) {
        this.key = key;
        this.secret = secret;
        this.baseUrl = baseUrl;
    }
}
