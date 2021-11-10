package com.matster.taxi.order.system.customerservice.controller;

import com.matster.taxi.order.system.customerservice.entity.Customer;
import com.matster.taxi.order.system.customerservice.model.RegisterCustomerRequest;
import com.matster.taxi.order.system.customerservice.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Описание API для управления пользователями")
@RestController
@RequestMapping("/registry")
@AllArgsConstructor
public class RegistryController {

    private final CustomerService customerService;

    @PostMapping
    @ApiOperation("Регистрация пользователя")
    public ResponseEntity<Customer> createCustomer(@RequestBody RegisterCustomerRequest customerReq) {
        return ResponseEntity.ok().body(customerService.create(customerReq));
    }
}
