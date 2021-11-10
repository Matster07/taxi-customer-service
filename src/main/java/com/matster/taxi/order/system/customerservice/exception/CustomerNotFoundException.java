package com.matster.taxi.order.system.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String id) {
        super(id);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }

    public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
