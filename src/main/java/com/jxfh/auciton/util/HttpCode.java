package com.jxfh.auciton.util;

public enum HttpCode {

    OK(200, "OK"),

    BAD_REQUEST(400, "Bad Request"),

    NOT_FOUND(404, "Not Found"),

    SERVICE_UNAVAILABLE(500, "Server Busy");

    private final int value;

    private final String message;


    HttpCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int value() {
        return this.value;
    }

    public String getMessage() {
        return this.message;
    }


}
