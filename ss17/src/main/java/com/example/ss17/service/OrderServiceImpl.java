package com.example.ss17.service;

import com.example.ss17.entity.Orders;
import com.example.ss17.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Orders order) {
        orderRepository.save(order);
    }

    @Override
    public List<Orders> getOrdersByCustomerId(Integer customerId, int page, int size) {
        return orderRepository.findByCustomerIdWithPagination(customerId, page, size);
    }

    @Override
    public long countOrdersByCustomerId(Integer customerId) {
        return orderRepository.countByCustomerId(customerId);
    }

    @Override
    public Orders findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void update(Orders order) {
        orderRepository.update(order);
    }

    @Override
    public List<Orders> findAllWithFilter(int page, int size, String search, String status, String startDate, String endDate) {
        return orderRepository.findAllWithFilter(page, size, search, status, startDate, endDate);
    }

    @Override
    public long countWithFilter(String search, String status, String startDate, String endDate) {
        return orderRepository.countWithFilter(search, status, startDate, endDate);
    }

    @Override
    public long countAll() {
        return orderRepository.countAll();
    }

    @Override
    public double getTotalRevenue() {
        return orderRepository.getTotalRevenue();
    }
}

