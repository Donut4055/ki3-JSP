package com.example.ss15.service;


import com.example.ss15.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
}
