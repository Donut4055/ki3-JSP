package com.example.ss17.service;

import com.example.ss17.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void save(Product product);
    void update(Product product);
    void delete(Integer id);
    List<Product> findAllWithPagination(int page, int size, String search);
    long countWithSearch(String search);
    long countAll();
}
