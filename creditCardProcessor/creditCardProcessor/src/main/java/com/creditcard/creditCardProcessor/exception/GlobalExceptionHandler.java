package com.creditcard.creditCardProcessor.exception;

import com.creditcard.creditCardProcessor.dto.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream()
                .map(v -> {
                    String field = v.getPropertyPath().toString();
                    field = field.contains(".") ? field.substring(field.lastIndexOf('.') + 1) : field;
                    return field + ": " + v.getMessage();
                })
                .collect(Collectors.joining(", "));
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingParam(MissingServletRequestParameterException ex) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST,
                "Missing required parameter: " + ex.getParameterName());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST,
                "Invalid value '" + ex.getValue() + "' for parameter '" + ex.getName() + "'");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneral(Exception ex) {
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
