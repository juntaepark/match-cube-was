package com.carnival.matchcube.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class NoDataRes<T> {

    private int statusCode;
    private String responseMessage;

    public NoDataRes(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }

    public static<T> NoDataRes<T> noDataRes(final int statusCode, final String responseMessage) {
        return NoDataRes.<T>builder()
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}