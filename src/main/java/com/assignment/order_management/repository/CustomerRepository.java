package com.assignment.order_management.repository;

import com.assignment.order_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
