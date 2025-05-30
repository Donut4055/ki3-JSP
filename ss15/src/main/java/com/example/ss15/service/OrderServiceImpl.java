package com.example.ss15.service;


import com.example.ss15.model.Order;
import com.example.ss15.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public int createOrder(Order order) {
        return orderDAO.insertOrder(order);
    }

    @Override
    public List<Order> getOrdersByUser(int idUser) {
        return orderDAO.getOrdersByUser(idUser);
    }

    @Override
    public Order findById(int orderId) {
        return orderDAO.findById(orderId);
    }
}

