package com.assignment.order_management.service;

import com.assignment.order_management.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order createOrder(int customerId,double amount) throws Exception;
    public Optional<Order> findByOrderId(int id);
    public List<Order> findAllOrders();
}
