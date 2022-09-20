package com.vipera.empresaer.core.exceptions;

import java.time.LocalDateTime;

public class TemplateException {

    private String error;
    private  String message;

    private LocalDateTime date;


    public TemplateException(String error, String message) {
        this.error = error;
        this.message = message;
        this.date = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
