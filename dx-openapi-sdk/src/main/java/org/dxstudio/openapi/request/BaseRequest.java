package org.dxstudio.openapi.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.dxstudio.openapi.dto.BaseResponseDto;

@Data
public abstract class BaseRequest<T extends BaseResponseDto> {
    /**
     * 商户请求key
     */
    @NotBlank(message = "商户请求key不能为空")
    private String key;
    /**
     * 商户本地订单号
     */
    @NotBlank(message = "商户本地订单号不能为空")
    @Size(max = 64)
    private String localOrderId;

    /**
     * 商户本地用户ID
     */
    @Size(max = 32)
    private String localUserId;

    /**
     * 回调地址(为空使用商户默认回调地址)
     */
    @Size(max = 1024)
    private String notifyUrl;

    /**
     * 成功后自动跳转地址
     */
    @Size(max = 1024, message = "订单成功后跳转地址不能超过1024")
    private String successRedirectUrl;

    /**
     * 回调信息中是否需要包含链转账信息
     */
    private Boolean isBlockchain = false;

    public abstract Class<T> getResponseClass();

    public abstract String getBasePath();


}
