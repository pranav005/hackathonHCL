package com.creditcard.creditCardProcessor.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;

    private ErrorResponse(HttpStatus httpStatus, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
    }

    public static ErrorResponse of(HttpStatus httpStatus, String message) {
        return new ErrorResponse(httpStatus, message);
    }
}
