package com.example.ss15.service;


import com.example.ss15.model.Cart;
import com.example.ss15.repository.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Override
    public void addToCart(int idUser, int idProduct, int quantity) {
        cartDAO.insertCart(idUser, idProduct, quantity);
    }

    @Override
    public List<Cart> getCartByUser(int idUser) {
        return cartDAO.getCartByUser(idUser);
    }

    @Override
    public void removeCartItem(int idCart) {
        cartDAO.deleteCartItem(idCart);
    }
}

