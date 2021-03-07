package com.carnival.matchcube.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DefaultRes<T> {

    private boolean isSuccess;
    private int statusCode;
    private String responseMessage;
    private T data;

    public DefaultRes(final boolean isSuccess, final int statusCode, final String responseMessage) {
        this.isSuccess = isSuccess;
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> DefaultRes<T> res(final boolean isSuccess, final int statusCode, final String responseMessage) {
        return res(isSuccess, statusCode, responseMessage, null);
    }

    public static<T> DefaultRes<T> res(final boolean isSuccess, final int statusCode, final String responseMessage, final T t) {
        return DefaultRes.<T>builder()
                .data(t)
                .isSuccess(isSuccess)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}