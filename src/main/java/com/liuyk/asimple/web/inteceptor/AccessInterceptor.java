package com.liuyk.asimple.web.inteceptor;

import com.liuyk.asimple.entity.RequestHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author liuyk
 */
@Component
public class AccessInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AccessInterceptor.class);

    public static final String TERMINAL_TYPE = "terminaltype";
    public static final String TRACE_ID = "trace_id";
    public static final String VERSION = "version";
    public static final String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(TRACE_ID);
        RequestHolder.setTraceId(StringUtils.isEmpty(traceId) ? "" : traceId);

        String version = request.getHeader(VERSION);
        RequestHolder.setVersion(Objects.isNull(version) ? -1 : Integer.parseInt(version.trim()));

        String terminalType = request.getHeader(TERMINAL_TYPE);
        RequestHolder.setTerminalType(Objects.isNull(terminalType) ? -1 : Integer.parseInt(terminalType.trim()));

        String token = request.getHeader(TOKEN);
        RequestHolder.setToken(token);
        log.info("RequestHolder uri={}, traceId={}, version={}, terminalType={}, token={}", request.getRequestURI(), RequestHolder.getTraceId(), RequestHolder.getVersion(), RequestHolder.getTerminalType(), RequestHolder.getToken());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
