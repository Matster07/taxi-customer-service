package com.matster.taxi.order.system.customerservice.model;

import lombok.Data;

@Data
public class CreateOrderResponse {

    private Integer orderId;
    private String start;
    private String destination;
}
