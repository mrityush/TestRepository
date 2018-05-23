package com.restservices.app.dto;

/**
 * Created by Priya on 7/12/17.
 */
public class MyObjDto {
    private String value;

    public MyObjDto(String value) {
        this.value = value;
    }

    public MyObjDto() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
