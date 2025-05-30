package com.example.ss15.repository;


import com.example.ss15.model.Order;
import com.example.ss15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class OrderDAO {

    public int insertOrder(Order order) {
        String sql = "{call insert_order(?, ?, ?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, order.getIdUser());
            cs.setString(2, order.getRecipientName());
            cs.setString(3, order.getAddress());
            cs.setString(4, order.getPhonenumber());
            cs.registerOutParameter(5, Types.INTEGER);
            cs.execute();
            return cs.getInt(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Order> getOrdersByUser(int idUser) {
        List<Order> list = new ArrayList<>();
        String sql = "{call get_orders_by_user(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idUser);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Order o = new Order();
                    o.setOrderId(rs.getInt("orderId"));
                    o.setIdUser(rs.getInt("idUser"));
                    o.setRecipientName(rs.getString("recipientName"));
                    o.setAddress(rs.getString("address"));
                    o.setPhonenumber(rs.getString("phonenumber"));
                    o.setOrderDate(rs.getTimestamp("orderDate"));
                    list.add(o);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Order findById(int orderId) {
        String sql = "{call find_order_by_id(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, orderId);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    Order order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setIdUser(rs.getInt("idUser"));
                    order.setRecipientName(rs.getString("recipientName"));
                    order.setAddress(rs.getString("address"));
                    order.setPhonenumber(rs.getString("phonenumber"));
                    order.setOrderDate(rs.getTimestamp("orderDate"));
                    return order;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

