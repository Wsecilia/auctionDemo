package com.jxfh.auciton.pojo;

import java.io.Serializable;

public class RestResult<T> implements Serializable {

    final private Integer code;// 状态码

    final private String message;// 状态信息

    final private T data;// 返回数据

    private RestResult(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static final class Builder<T> {
        private Integer code;
        private String message;
        private T data;

        public Builder code(final Integer code) {
            this.code = code;
            return this;
        }

        public Builder message(final String message) {
            this.message = message;
            return this;
        }

        public Builder data(final T data) {
            this.data = data;
            return this;
        }

        public RestResult build() {
            return new RestResult(this);
        }
    }
}
