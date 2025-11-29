package org.dxstudio.openapi.sdk;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dxstudio.openapi.config.ClientConfig;
import org.dxstudio.openapi.request.BaseRequest;
import org.dxstudio.openapi.response.BaseResponse;
import org.dxstudio.openapi.untils.HttpClientUntil;
import org.dxstudio.openapi.untils.SignUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Slf4j
public class Client {

    /**
     * 客户端初始化配置类
     */
    private final ClientConfig clientConfig;
    // 添加 Validator 实例
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    @SneakyThrows
    public <T extends BaseResponse> T execute(@Valid BaseRequest<T> request) {
        // 参数校验
        if (request == null) {
            throw new IllegalArgumentException("请求参数不能为空");
        }

        if (clientConfig == null || StringUtils.isBlank(clientConfig.getSecret()) || StringUtils.isBlank(clientConfig.getBaseUrl())) {
            throw new IllegalStateException("配置信息不完整");
        }
        // 手动触发校验
        Set<ConstraintViolation<BaseRequest<T>>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder("参数校验失败:");
            for (ConstraintViolation<BaseRequest<T>> violation : violations) {
                sb.append(violation.getPropertyPath())
                        .append(" ")
                        .append(violation.getMessage())
                        .append("; ");
            }
            throw new IllegalArgumentException(sb.toString());
        }

        try {
            // 直接使用对象而非序列化后再反序列化
            JSONObject params = new JSONObject();
            // 这里保持原有逻辑，如需优化可考虑反射或其他方式直接转换
            params = JSON.parseObject(JSON.toJSONString(request));

            // 签名
            String sign = SignUtil.getSign(params, clientConfig.getSecret());
            params.put("sign", sign);

            log.info("请求路径: {}", clientConfig.getBaseUrl()+request.getBasePath());
            log.info("请求参数: {}", params);
            // POST 调用
            String respJson = HttpClientUntil.postJson(clientConfig.getBaseUrl(), request.getBasePath(), params, null);

            log.info("请求已发送，开始处理响应");
            if (respJson.isEmpty()) {
                throw new RuntimeException("远程服务返回空响应");
            }

            JSONObject jsonObject = JSONObject.parseObject(respJson);
            log.info("响应结果: {}", jsonObject);
            if (jsonObject == null) {
                throw new RuntimeException("无法解析远程服务响应");
            }

            // JSON 映射成响应对象
            if ("0".equals(jsonObject.getString("code"))) {
                return JSON.parseObject(respJson, request.getResponseClass());
            } else {
                T message = request.getResponseClass().newInstance();
                message.setMessage(jsonObject.getString("message"));
                message.setCode(jsonObject.getString("code"));
                return message;
            }
        } catch (Exception e) {
            log.error("执行请求时发生错误: {}", e.getMessage(), e);
            throw e;
        }
    }


}
