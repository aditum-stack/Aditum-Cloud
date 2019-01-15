package com.ten.aditum.cloud.gateway.model;

/**
 * 响应码
 */
public class ErrorCode {
    // 成功
    public static final int OK = 200;

    // 客户端错误
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUNT = 404;

    // 服务端错误
    public static final int SERVER_ERROR = 500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;

    // 微服务不可用
    public static final int MICRO_SERVICE_UNAVAILABLE = 40001;
}
