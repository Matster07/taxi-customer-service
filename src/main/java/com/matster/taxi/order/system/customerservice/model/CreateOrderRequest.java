package com.matster.taxi.order.system.customerservice.model;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long customerId;
    private String start;
    private String destination;
}
