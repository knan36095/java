package org.dxstudio.openapi.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Config {

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
