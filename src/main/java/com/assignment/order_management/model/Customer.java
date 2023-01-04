package com.assignment.order_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private Integer orderCount;
    private String category;
    public Customer(String username, Integer orderCount, String category) {
        this.username=username;
        this.orderCount=orderCount;
        this.category=category;
    }
}
