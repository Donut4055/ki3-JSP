package com.example.ss15.service;


import com.example.ss15.model.Cart;
import java.util.List;

public interface CartService {
    void addToCart(int idUser, int idProduct, int quantity);
    List<Cart> getCartByUser(int idUser);
    void removeCartItem(int idCart);
}
