package com.assignment.order_management.service;

import com.assignment.order_management.model.Customer;
import com.assignment.order_management.model.DiscountDetail;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer addCustomer(String username);
    public List<DiscountDetail> findAllDiscountDetails();
    public Optional<Customer> findCustomerById(int id);
    public List<Customer> findAllCustomers();
}
