package com.example.ss6.Model;



public class ProductCart {
    private int id;
    private int productId;
    private int quantity;

    public ProductCart() {
    }
    public ProductCart(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public ProductCart(int id, int productId, int quantity) {
        this(productId, quantity);
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public int getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
