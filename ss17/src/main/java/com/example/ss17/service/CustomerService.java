package com.example.ss17.service;


import com.example.ss17.entity.Customer;

import java.util.List;

public interface CustomerService {
    boolean register(Customer customer, StringBuilder errorMsg);
    Customer login(String username, String password);
    void update(Customer customer);
    Customer findById(Integer id);

    List<Customer> findAllWithPagination(int page, int size, String search);
    long countWithSearch(String search);
    long countAll();
}

