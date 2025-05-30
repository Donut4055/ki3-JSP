package com.example.ss15.repository;


import com.example.ss15.model.OrderDetail;
import com.example.ss15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class OrderDetailDAO {

    public void insertOrderDetail(OrderDetail detail) {
        String sql = "{call insert_order_detail(?, ?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, detail.getOrderId());
            cs.setInt(2, detail.getProductId());
            cs.setInt(3, detail.getQuantity());
            cs.setDouble(4, detail.getCurrentPrice());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "{call get_order_details(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, orderId);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    OrderDetail od = new OrderDetail();
                    od.setId(rs.getInt("id"));
                    od.setOrderId(rs.getInt("orderId"));
                    od.setProductId(rs.getInt("productId"));
                    od.setQuantity(rs.getInt("quantity"));
                    od.setCurrentPrice(rs.getDouble("currentPrice"));
                    od.setProductName(rs.getString("name"));
                    list.add(od);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
