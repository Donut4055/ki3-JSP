package com.example.ss15.model;


public class Cart {
    private Integer idCart;
    private Integer idUser;
    private Integer idProduct;
    private Integer quantity;
    private String productName;
    private Double productPrice;

    public Integer getIdCart() {
        return idCart;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}

