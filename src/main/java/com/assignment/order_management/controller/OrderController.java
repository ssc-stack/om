package com.assignment.order_management.controller;

import com.assignment.order_management.model.Order;
import com.assignment.order_management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //http://localhost:8080/api/v1/create-order/cust-id/1/amount/100
    @GetMapping("/create-order/cust-id/{cust-id}/amount/{amount}")
    public Order createOrder(@PathVariable("cust-id") int customerId,@PathVariable double amount)
            throws Exception {
        return orderService.createOrder(customerId,amount);
    }

    //http://localhost:8080/api/v1/order/id/1
    @GetMapping("/order/id/{id}")
    public Order findOrderById(@PathVariable int id) {
        return orderService.findByOrderId(id).get(); // get() for optional
    }

    //http://localhost:8080/api/v1/orders
    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

}
