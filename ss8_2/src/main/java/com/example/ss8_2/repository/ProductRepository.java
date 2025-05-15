package com.example.ss8_2.repository;

import com.example.ss8_2.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Product 1", 100.0));
        products.add(new Product(2, "Product 2", 150.0));
        products.add(new Product(3, "Product 3", 200.0));

        return products;
    }
}
