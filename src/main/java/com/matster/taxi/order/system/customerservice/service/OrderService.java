package com.matster.taxi.order.system.customerservice.service;

import com.matster.taxi.order.system.customerservice.entity.Customer;
import com.matster.taxi.order.system.customerservice.exception.OrderCreationException;
import com.matster.taxi.order.system.customerservice.model.CreateOrderRequest;
import com.matster.taxi.order.system.customerservice.model.CreateOrderResponse;
import com.matster.taxi.order.system.customerservice.model.ProcessOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderService {

    @Value(value = "${app.integration.order-service-address}")
    private String orderServiceAddress;

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createOrder(ProcessOrderRequest orderRequest, Long customerId) {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();

        createOrderRequest.setCustomerId(customerId);
        createOrderRequest.setStart(orderRequest.getStart());
        createOrderRequest.setDestination(orderRequest.getDestination());

        ResponseEntity<CreateOrderResponse> response = restTemplate
                .postForEntity(
                        "http://" + orderServiceAddress + "/api/order/v1/orders",
                        createOrderRequest,
                        CreateOrderResponse.class
                );

        Optional<CreateOrderResponse> responseBody = Optional.ofNullable(response.getBody());

        return responseBody.orElseThrow(() -> new OrderCreationException(customerId)).toString();
    }
}
