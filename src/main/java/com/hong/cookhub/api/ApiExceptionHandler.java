package com.hong.cookhub.api;

import com.hong.cookhub.model.ApiError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hong2 on 2018. 10. 8.
 * Time : AM 12:54
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final Map<Class<? extends Exception>, String> messageMappings =
            Collections.unmodifiableMap(new LinkedHashMap(){
                {
                    put(HttpMessageNotReadableException.class, "Request body is invalid");
                }
            });

    private String resolveMessage(Exception ex, String defaultMessage) {
        return messageMappings.entrySet().stream()
                .filter(entry -> entry.getKey().isAssignableFrom(ex.getClass()))
                .findFirst().map(Map.Entry::getValue).orElse(defaultMessage);
    }


    @ExceptionHandler
    public ResponseEntity<Object> handleSystemException(Exception ex, WebRequest request) {
        ApiError apiError = createApiError(ex, "System error is occurred");
        return super.handleExceptionInternal(ex, apiError, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ApiError createApiError(Exception ex, String defaultMessage) {
        ApiError apiError = ApiError.builder()
                .message(resolveMessage(ex, defaultMessage))
                .documentationUrl("http:://cookhub.com:8080/api/errors")
                .build();
        return apiError;
    }

    private ApiError createApiError(Exception ex) {
        ApiError apiError = ApiError.builder()
                .message(resolveMessage(ex, ex.getMessage()))
                .documentationUrl("http:://cookhub.com:8080/api/errors")
                .build();
        return apiError;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = createApiError(ex);
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }
}
