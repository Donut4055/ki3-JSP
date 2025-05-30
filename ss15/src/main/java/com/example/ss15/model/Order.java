package com.example.ss15.model;


import java.util.Date;

public class Order {
    private Integer orderId;
    private Integer idUser;
    private String recipientName;
    private String address;
    private String phonenumber;
    private Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
