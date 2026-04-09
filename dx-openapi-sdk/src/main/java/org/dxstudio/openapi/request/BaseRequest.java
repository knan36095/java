package org.dxstudio.openapi.request;



import com.alibaba.fastjson2.annotation.JSONField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.dxstudio.openapi.response.BaseResponse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基础请求参数
 * @param <T>
 */
@Data
public abstract class BaseRequest<T extends BaseResponse> {

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

    @JSONField(serialize = false)
    public abstract Class<T> getResponseClass();
    @JSONField(serialize = false)
    public abstract String getBasePath();


}
