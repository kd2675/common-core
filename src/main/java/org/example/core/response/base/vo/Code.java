package org.example.core.response.base.vo;

import org.example.core.response.base.exception.GeneralException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum Code {

    // 충돌 방지를 위한 Code format
    // X1XXX: 제이
    // X2XXX: 셀리나
    // X3XXX: 메이슨
    // ex) 메이슨이 닉네임 중복 에러코드를 만든다면
    // USER_NICKNAME_DUPLICATED(13010, HttpStatus.BAD_REQUEST, "User nickname duplicated"),

    OK(1, HttpStatus.OK, "Ok"),

    BAD_REQUEST(10400, HttpStatus.OK, "BAD_REQUEST"),
    NOT_FOUND(10404, HttpStatus.OK, "NOT_FOUND"),
    INTERNAL_ERROR(500, HttpStatus.OK, "INTERNAL_SERVER_ERROR"),

    VALIDATION_ERROR(20300, HttpStatus.OK, "Validation error"),
    NOT_MATCH_PASSWORD(20301, HttpStatus.OK, "Not match password"),
    NO_SEARCH_USER(20302, HttpStatus.OK, "No search user"),
    NOT_ENOUGH_POINT(40303, HttpStatus.OK, "Not Enough point"),
    NO_SEARCH_ORDER(40304, HttpStatus.OK, "No search order"),

    USED_AUTHORIZATION_CODE(20400, HttpStatus.OK, "Used authorization code"),

    UNAUTHORIZED(40070, HttpStatus.OK, "User unauthorized"),
    TOKEN_SIGNATURE(40071, HttpStatus.OK, "SignatureException"),
    TOKEN_MALFORMED(40072, HttpStatus.OK, "MalformedException"),
    TOKEN_EXPIRED(40073, HttpStatus.OK, "ExpiredException"),
    TOKEN_UNSUPPORTED(40074, HttpStatus.OK, "UnsupportedException"),
    TOKEN_ILLEGAL_ARGUMENT(40075, HttpStatus.OK, "IllegalArgumentException"),

    DATA_ACCESS_ERROR(50001, HttpStatus.INTERNAL_SERVER_ERROR, "Data access error");


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    public String getMessage(Throwable e) {
        return this.getMessage(this.getMessage() + " - " + e.getMessage());
        // 결과 예시 - "Validation error - Reason why it isn't valid"
    }

    public String getMessage(String message) {
//        return Optional.ofNullable(message)
//                .orElse(this.getMessage());
        return Optional.ofNullable(message)
                .filter(v->!v.isEmpty())
                .orElse(this.getMessage());
    }

    public static Code valueOf(HttpStatus httpStatus) {
        if (httpStatus == null) {
            throw new GeneralException("HttpStatus is null.");
        }

        return Arrays.stream(values())
                .filter(errorCode -> errorCode.getHttpStatus() == httpStatus)
                .findFirst()
                .orElseGet(() -> {
                    if (httpStatus.is4xxClientError()) {
                        return Code.BAD_REQUEST;
                    } else if (httpStatus.is5xxServerError()) {
                        return Code.INTERNAL_ERROR;
                    } else {
                        return Code.OK;
                    }
                });
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.name(), this.getCode());
    }
}