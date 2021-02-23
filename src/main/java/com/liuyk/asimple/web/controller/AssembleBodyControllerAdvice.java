package com.liuyk.asimple.web.controller;

import com.liuyk.asimple.entity.R;
import com.liuyk.asimple.enums.BizExceptionEnum;
import com.liuyk.asimple.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class AssembleBodyControllerAdvice implements ResponseBodyAdvice {

    private static final Logger log = LoggerFactory.getLogger(AssembleBodyControllerAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class clz) {
        if (methodParameter.getMethod() == null) {
            return false;
        }

        Class<?> returnType = methodParameter.getMethod().getReturnType();
        return !returnType.isAssignableFrom(R.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return R.successResult(o);
    }

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public R<Object> exceptionHandler(BizException e) {
        return new R<>(e.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R<Object> exceptionHandler(Exception e) {
        log.error("系统发生异常，请修复。message={}", e.getMessage(), e);
        return new R<>(BizExceptionEnum.SYSTEM_ERROR.getCode(), BizExceptionEnum.SYSTEM_ERROR.getMessage(), null);
    }

}
