package com.kfh.educationservice.common.exception.type;

public class BusinessException extends RuntimeException {

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
    }
}
