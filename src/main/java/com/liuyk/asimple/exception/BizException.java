package com.liuyk.asimple.exception;

import com.liuyk.asimple.enums.BizExceptionEnum;

/**
 * @author liuyk
 */
public class BizException extends RuntimeException {

    private Integer code;
    private String message;

    public BizException(BizExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }

    private BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BizException throwException(BizExceptionEnum exceptionEnum) {
        return new BizException(exceptionEnum);
    }

}
