package com.liuyk.asimple.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class R<T> implements Serializable {

    private transient static final int CODE_SUCCESS = 1000;

    private Integer code;
    private String msg;
    private T data;

    public R() {
        this.code = CODE_SUCCESS;
        this.msg = "";
    }

    public R(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static <T> R<T> successResult(T data) {
        return new R<>(CODE_SUCCESS, "", data);
    }



    @JsonIgnore
    public boolean isSuccess() {
        return code != null && code == CODE_SUCCESS;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
