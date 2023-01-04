package com.assignment.order_management.service;

import com.assignment.order_management.constants.CategoryConstants;
import com.assignment.order_management.model.Customer;
import com.assignment.order_management.model.DiscountDetail;
import com.assignment.order_management.repository.CustomerRepository;
import com.assignment.order_management.repository.DiscountDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DiscountDetailRepository discountDetailRepository;

    @Override
    public Customer addCustomer(String username) {
        Customer newCustomer=new Customer(username,0, CategoryConstants.REGULAR);
        return customerRepository.save(newCustomer);
    }

    @Override
    public List<DiscountDetail> findAllDiscountDetails() {
        return discountDetailRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
