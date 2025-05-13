package com.example.ss6.Service;

import com.example.ss6.Model.Product;
import com.example.ss6.Model.ProductCart;
import com.example.ss6.DAO.ProductCartDAO;

import java.util.ArrayList;
import java.util.List;

public class ProductCartService {
    private final ProductCartDAO productCartDao = new ProductCartDAO();

    public List<Product> getAllProducts() {
        List<Product> products = productCartDao.getAllProducts();
        if (products == null) {
            return new ArrayList<>();
        }
        return products;
    }

    public boolean addProductCart(int productId, int quantity) {
        return productCartDao.addProductCart(productId, quantity);
    }

    public boolean removeProductCart(int productCartId) {
        return productCartDao.removeProductCart(productCartId);
    }

    public List<ProductCart> getProductCart() {
        List<ProductCart> productCart = productCartDao.getProductCart();
        if (productCart == null) {
            return new ArrayList<>();
        }
        return productCart;
    }

    public Product getProductById(int productId) {
        return productCartDao.getProductById(productId);
    }
}
