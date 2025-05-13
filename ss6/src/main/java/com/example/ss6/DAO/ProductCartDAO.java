package com.example.ss6.DAO;

import Util.ConnectionDB;
import com.example.ss6.Model.Product;
import com.example.ss6.Model.ProductCart;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCartDAO{
    public List<Product> getAllProducts() {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Product> products = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call GetAllProducts()}");
            rs = stmt.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImageUrl(rs.getString("imageUrl"));
                products.add(product);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

        return products;
    }

    public boolean addProductCart(int productId, int quantity) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean flag = false;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call AddProductToCart(?,?)}");
            stmt.setInt(1, productId);
            stmt.setInt(2,quantity);
            stmt.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return flag;
    }

    public boolean removeProductCart(int productCartId) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean flag = false;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call RemoveProductFromCart(?)}");
            stmt.setInt(1, productCartId);
            stmt.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return flag;
    }

    public List<ProductCart> getProductCart() {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<ProductCart> productCart = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call get_all_product_cart()}");
            rs = stmt.executeQuery();
            productCart = new ArrayList<>();
            while (rs.next()) {
                ProductCart product = new ProductCart();
                product.setId(rs.getInt("id"));
                product.setProductId(rs.getInt("product_id"));
                product.setQuantity(rs.getInt("quantity"));
                productCart.add(product);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

        return productCart;
    }

    public Product getProductById(int productId) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call GetAllProducts()}");
            rs = stmt.executeQuery();
            product = new Product();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImageUrl(rs.getString("imageUrl"));
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

        return product;
    }
}
