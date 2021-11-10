package com.matster.taxi.order.system.customerservice.controller;

import com.matster.taxi.order.system.customerservice.service.CustomerService;
import com.matster.taxi.order.system.customerservice.service.OrderService;
import com.matster.taxi.order.system.customerservice.model.ProcessOrderRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Описание API для управления заказами пользователя")
@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @PostMapping(value = "/{id}/order")
    @ApiOperation("Создание заказа")
    public ResponseEntity<Object> processOrder(@ApiParam(value = "Идентификатор пользователя в БД") @PathVariable String id,
                                               @RequestBody ProcessOrderRequest processOrderRequest) {
        customerService.checkIfExist(id);

        String orderId = orderService.createOrder(processOrderRequest, Long.valueOf(id));

        return ResponseEntity.ok().body(orderId);
    }

}
