package org.example.core.response.base.dto;

import lombok.*;
import org.example.core.response.base.vo.Code;

@Getter
@ToString
public class ResponseDTO {
    private Boolean success;
    private Integer code;
    private String message;

    private ResponseDTO() {
    }

    protected ResponseDTO(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static ResponseDTO of(Boolean success, Code code) {
        return new ResponseDTO(success, code.getCode(), code.getMessage());
    }

    public static ResponseDTO of(Boolean success, Code errorCode, Exception e) {
        return new ResponseDTO(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static ResponseDTO of(Boolean success, Code errorCode, String message) {
        return new ResponseDTO(success, errorCode.getCode(), errorCode.getMessage(message));
    }
}