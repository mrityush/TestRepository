package com.restservices.app.dto;

import com.restservices.app.utils.ApplicationConstant;

/**
 * Created by Priya on 8/4/18.
 */

public class SuccessResponseDto<T> implements ResponseDto<T> {
    private Integer code = ApplicationConstant.HTTP_RESPONSE_SUCCESS_CODE;
    private T data;
    private String message = null;
    private Integer status = ApplicationConstant.SUCCESS_STATUS_CODE;
    private String numItems = "";
    private String pageSize;

    public String getNumItems() {
        return numItems;
    }

    public void setNumItems(String numItems) {
        this.numItems = numItems;
    }

    public SuccessResponseDto() {
    }

    public SuccessResponseDto(T data) {
        this.data = data;
    }

    public SuccessResponseDto(String message) {
        this.message = message;
    }

    public SuccessResponseDto(T data2, String message2) {
        this.data = data2;
        this.message = message2;
    }

    public SuccessResponseDto(T data2, String message2, Integer status) {
        this(data2, message2);
        this.status = status;
    }

    public SuccessResponseDto(Integer status) {
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

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageSize() {
        return pageSize;
    }
}

