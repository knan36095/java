package org.dxstudio.openapi.response;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private String code;
    private Boolean success=true;
    private String message;
    private T data;
}
