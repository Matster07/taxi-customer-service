package com.matster.taxi.order.system.customerservice.model;

import lombok.Data;

@Data
public class ProcessOrderRequest {

    private String start;
    private String destination;
}
