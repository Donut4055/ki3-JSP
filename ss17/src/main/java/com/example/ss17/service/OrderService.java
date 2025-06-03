package com.example.ss17.service;

import com.example.ss17.entity.Orders;

import java.util.List;

public interface OrderService {
    void save(Orders order);
    List<Orders> getOrdersByCustomerId(Integer customerId, int page, int size);
    long countOrdersByCustomerId(Integer customerId);
    Orders findById(Integer id);
    void update(Orders order);

    List<Orders> findAllWithFilter(int page, int size, String search, String status, String startDate, String endDate);
    long countWithFilter(String search, String status, String startDate, String endDate);
    long countAll();
    double getTotalRevenue();
}

