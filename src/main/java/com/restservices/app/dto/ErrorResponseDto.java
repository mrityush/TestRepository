package com.restservices.app.dto;

import com.restservices.app.utils.ApplicationConstant;

/**
 * Created by Priya on 8/4/18.
 */


public class ErrorResponseDto<T> implements ResponseDto<T> {
    private Integer code = ApplicationConstant.HTTP_RESPONSE_ERROR_CODE;
    private T data;
    private String message = null;
    private Integer status = ApplicationConstant.ERROR_STATUS_CODE;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(String message) {
        this.message = message;
    }

    public ErrorResponseDto(T data) {
        this.data = data;
    }

    public ErrorResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ErrorResponseDto(T data, String message, Integer status) {
        this(data, message);
        this.status = status;
    }

    public ErrorResponseDto(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }
}

