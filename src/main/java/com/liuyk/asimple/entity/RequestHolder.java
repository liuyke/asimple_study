package com.liuyk.asimple.entity;

/**
 * 客户端请求的holder，包含traceId、version
 *
 * @author liuyunke
 */
public class RequestHolder {

    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

    private static final ThreadLocal<Integer> VERSION = new ThreadLocal<>();

    private static final ThreadLocal<Integer> TERMINAL_TYPE = new ThreadLocal<>();

    private static final ThreadLocal<String> TOKEN = new ThreadLocal<>();

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static void removeTraceId() {
        TRACE_ID.remove();
    }

    public static void setVersion(Integer version) {
        VERSION.set(version);
    }

    public static Integer getVersion() {
        return VERSION.get();
    }

    public static void removeVersion() {
        VERSION.remove();
    }


    public static Integer getTerminalType() {
        return TERMINAL_TYPE.get();
    }

    public static void setTerminalType(Integer terminalType) {
        TERMINAL_TYPE.set(terminalType);
    }

    public static void removeTerminalType() {
        TERMINAL_TYPE.remove();
    }

    public static String getToken() {
        return TOKEN.get();
    }

    public static void setToken(String token) {
        TOKEN.set(token);
    }

    public static void removeToken() {
        TOKEN.remove();
    }
}
