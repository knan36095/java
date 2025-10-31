package org.dxstudio.openapi.dto;

import lombok.Data;

@Data
public class BaseResponseDto<T> {
    private String code;
    private Boolean success=true;
    private String message;
    private T data;
}
