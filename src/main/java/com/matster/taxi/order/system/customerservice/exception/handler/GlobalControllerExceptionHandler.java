package com.matster.taxi.order.system.customerservice.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matster.taxi.order.system.customerservice.exception.CustomerNotFoundException;
import com.matster.taxi.order.system.customerservice.exception.OrderCreationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.List;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalControllerExceptionHandler {

    private final ObjectMapper mapper;

    /**
     * Default exception handler.
     *
     * @param throwable Exception object.
     * @param request   Request.
     * @return {@link ResponseEntity}.
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorResponse> defaultExceptionHandler(Throwable throwable, ServletWebRequest request) {
        var annotation = throwable.getClass().getAnnotation(ResponseStatus.class);
        var status = annotation != null ? annotation.value() : HttpStatus.INTERNAL_SERVER_ERROR;

        return build(throwable, request, status, false);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFoundExceptionHandler(CustomerNotFoundException exception, ServletWebRequest request) {
        return build(exception, request, HttpStatus.NOT_FOUND, true);
    }

    @ExceptionHandler(OrderCreationException.class)
    public ResponseEntity<ApiErrorResponse> notFoundExceptionHandler(OrderCreationException exception, ServletWebRequest request) {
        return build(exception, request, HttpStatus.CONFLICT, true);
    }

    private ResponseEntity<ApiErrorResponse> build(Throwable throwable, ServletWebRequest request, HttpStatus status, boolean isDetailed) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .title(throwable.getClass().getSimpleName())
                .status(status.value())
                .detail(isDetailed ? throwable.getMessage() : "")
                .instance(request.getRequest().getRequestURI())
                .build(), status);
    }

    @Value
    @Builder
    private static class ApiErrorResponse {
        private String type;
        private String title;
        private int status;
        private String detail;
        private String instance;
        private List<ErrorRecord> errors;
    }

    @Value
    @Builder
    private static class ErrorRecord {
        private String name;
        private String reason;
    }

}
