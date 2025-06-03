package com.example.ss17.service;

import com.example.ss17.entity.Product;
import com.example.ss17.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findAllWithPagination(int page, int size, String search) {
        return productRepository.findAllWithPagination(page, size, search);
    }

    @Override
    public long countWithSearch(String search) {
        return productRepository.countWithSearch(search);
    }

    @Override
    public long countAll() {
        return productRepository.countAll();
    }
}
