package com.vipera.empresaer.core.exceptions.types;

import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException{

    private String code;
    private String message;
    private HttpStatus status;

    public RestException(String code, String message, HttpStatus status) {
        super();
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
