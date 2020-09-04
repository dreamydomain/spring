package com.horace.spring.model.mongo;

import com.horace.spring.common.enums.ErrorType;

public class ResponseDto {
    private Object entity;
    private String message;
    private boolean success;
    private ErrorType errorType;

    public ResponseDto(Object entity, String message, boolean success, ErrorType errorType) {
        this.entity = entity;
        this.message = message;
        this.success = success;
        this.errorType = errorType;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
