package com.matster.taxi.order.system.customerservice.service;

import com.matster.taxi.order.system.customerservice.entity.Customer;
import com.matster.taxi.order.system.customerservice.exception.CustomerNotFoundException;
import com.matster.taxi.order.system.customerservice.model.RegisterCustomerRequest;
import com.matster.taxi.order.system.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void checkIfExist(String id) {
        Optional<Customer> customer = customerRepository.findCustomerById(Integer.valueOf(id));

        if (customer.isEmpty()) new CustomerNotFoundException("Customer with id " + id + " was not found");
    }

    public Customer create(RegisterCustomerRequest customerReq) {
        Customer customer = new Customer();

        customer.setFirstname(customerReq.getFirstname());
        customer.setSecondname(customerReq.getSecondname());

        customerRepository.save(customer);

        log.info("{} was successfully registered", customer);

        return customer;
    }
}
