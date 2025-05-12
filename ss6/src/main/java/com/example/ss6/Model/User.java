package com.example.ss6.Model;


public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User() {}

    //dùng cho việc đăng kí
    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email    = email;
        this.phone    = phone;
    }

    //contructor đầy đủ
    public User(int id, String username, String password, String email, String phone) {
        this(username, password, email, phone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
