package com.example.ss15.service;


import com.example.ss15.model.OrderDetail;
import com.example.ss15.repository.OrderDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Override
    public void addOrderDetail(OrderDetail detail) {
        orderDetailDAO.insertOrderDetail(detail);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailDAO.getOrderDetailsByOrderId(orderId);
    }
}

