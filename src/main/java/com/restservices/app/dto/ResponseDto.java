package com.restservices.app.dto;

/**
 * Created by Priya on 8/4/18.
 */
public interface ResponseDto<T> {

    public Integer getCode();

    public T getData();

    public String getMessage();

    public Integer getStatus();

    public void setCode(Integer code);

    public void setData(T data);

    public void setMessage(String message);

    public void setStatus(Integer status);
}
