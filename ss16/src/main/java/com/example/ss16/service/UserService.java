package com.example.ss16.service;


import com.example.ss16.model.User;

public interface UserService {
    boolean register(User user, StringBuilder errorMsg);
    User login(String username, String password);
}
