package com.matster.taxi.order.system.customerservice.repository;

import com.matster.taxi.order.system.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerById(Integer id);
}
