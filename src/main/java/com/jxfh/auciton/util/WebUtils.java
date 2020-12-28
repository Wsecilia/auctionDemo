package com.jxfh.auciton.util;


import com.jxfh.auciton.pojo.RestResult;

public final class WebUtils {

    public static final String INDEX = "index";

    public final static <T> RestResult ok(String message, T data) {
        return new RestResult.Builder().code(HttpCode.OK.value()).message(message).data(data).build();
    }

    public final static <T> RestResult ok(T data) {
        return new RestResult.Builder().code(HttpCode.OK.value()).message(HttpCode.OK.getMessage()).data(data).build();
    }

    public final static RestResult paramError() {
        return new RestResult.Builder().code(HttpCode.BAD_REQUEST.value()).message(HttpCode.BAD_REQUEST.getMessage())
                .data(null)
                .build();
    }

    public final static RestResult paramError(Object data) {
        return new RestResult.Builder().code(HttpCode.BAD_REQUEST.value()).message(HttpCode.BAD_REQUEST.getMessage())
                .data(data)
                .build();
    }

    public final static RestResult paramError(String message) {
        return new RestResult.Builder().code(HttpCode.BAD_REQUEST.value()).message(message).data(null).build();
    }


    public final static <T> RestResult paramError(String message, T data) {
        return new RestResult.Builder().code(HttpCode.BAD_REQUEST.value()).message(message).data(data)
                .build();
    }

    public final static RestResult serverError() {
        return new RestResult.Builder().code(HttpCode.SERVICE_UNAVAILABLE.value()).message(HttpCode
                .SERVICE_UNAVAILABLE.getMessage()).data(null).build();
    }

    public final static RestResult serverError(String message) {
        return new RestResult.Builder().code(HttpCode.SERVICE_UNAVAILABLE.value()).message(message).data(null).build();
    }

    public final static <T> RestResult serverError(String message, T data) {
        return new RestResult.Builder().code(HttpCode.SERVICE_UNAVAILABLE.value()).message(message).data(data).build();
    }

    public final static RestResult notFound() {
        return new RestResult.Builder().code(HttpCode.NOT_FOUND.value()).message(HttpCode.NOT_FOUND
                .getMessage())
                .data(null).build();
    }

    public final static RestResult notFound(String message) {
        return new RestResult.Builder().code(HttpCode.NOT_FOUND.value()).message(message)
                .data(null).build();
    }

}
