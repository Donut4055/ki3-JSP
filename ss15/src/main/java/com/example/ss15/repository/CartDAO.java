package com.example.ss15.repository;


import com.example.ss15.model.Cart;
import com.example.ss15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class CartDAO {

    public void insertCart(int idUser, int idProduct, int quantity) {
        String sql = "{call insert_cart(?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idUser);
            cs.setInt(2, idProduct);
            cs.setInt(3, quantity);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cart> getCartByUser(int idUser) {
        List<Cart> list = new ArrayList<>();
        String sql = "{call get_cart_by_user(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idUser);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Cart c = new Cart();
                    c.setIdCart(rs.getInt("idCart"));
                    c.setIdUser(rs.getInt("idUser"));
                    c.setIdProduct(rs.getInt("idProduct"));
                    c.setQuantity(rs.getInt("quantity"));
                    c.setProductName(rs.getString("name"));
                    c.setProductPrice(rs.getDouble("price"));
                    list.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteCartItem(int idCart) {
        String sql = "{call delete_cart_item(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idCart);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

