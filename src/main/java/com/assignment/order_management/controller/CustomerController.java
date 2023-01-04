package com.assignment.order_management.controller;

import com.assignment.order_management.model.Customer;
import com.assignment.order_management.model.DiscountDetail;
import com.assignment.order_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //http://localhost:8080/api/v1/add-customer/username/shashank
    @GetMapping("/add-customer/username/{username}")
    public Customer addCustomer(@PathVariable String username) {
        return customerService.addCustomer(username);
    }

    //http://localhost:8080/api/v1/customers/discountDetail
    @GetMapping("/customers/discountDetail")
    public List<DiscountDetail> findAllCustomerDiscountDetails() {
        return customerService.findAllDiscountDetails();
    }

    //http://localhost:8080/api/v1/customers/id/1
    @GetMapping("/customer/id/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id).get(); // returns Optional so using get()
    }

    //http://localhost:8080/api/v1/customers
    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
         return customerService.findAllCustomers();
    }

}
