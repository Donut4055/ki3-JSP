package com.example.ss8_2.service;

import com.example.ss8_2.Model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();
    public List<Product> getAllProducts() {


        products.add(new Product(1, "Product 1", 100.0));
        products.add(new Product(2, "Product 2", 150.0));
        products.add(new Product(3, "Product 3", 200.0));

        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getNextProductId() {
        return products.size() + 1;
    }
}
