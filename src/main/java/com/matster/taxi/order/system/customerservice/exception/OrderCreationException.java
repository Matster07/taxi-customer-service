package com.matster.taxi.order.system.customerservice.exception;

public class OrderCreationException extends RuntimeException {
    public OrderCreationException(Long id) {
        super("An error occured while creating order with user " + id);
    }
}
