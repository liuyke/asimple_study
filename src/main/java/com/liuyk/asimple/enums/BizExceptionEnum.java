package com.liuyk.asimple.enums;

public enum BizExceptionEnum {

    SYSTEM_ERROR(1001,"系统异常"),
    BAD_REQUEST(1002,"错误的请求参数"),
    NO_PERMISSION(1010,"非法请求！");
    ;

    BizExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
