package com.example.ss15.service;


import com.example.ss15.model.OrderDetail;
import java.util.List;

public interface OrderDetailService {
    void addOrderDetail(OrderDetail detail);
    List<OrderDetail> getOrderDetailsByOrderId(int orderId);
}

