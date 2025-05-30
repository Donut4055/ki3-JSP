package com.example.ss15.service;


import com.example.ss15.model.Order;
import java.util.List;

public interface OrderService {
    int createOrder(Order order);
    List<Order> getOrdersByUser(int idUser);
    Order findById(int orderId);
}

