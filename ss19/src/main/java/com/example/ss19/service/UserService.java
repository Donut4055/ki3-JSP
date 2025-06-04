package com.example.ss19.service;

import com.example.ss19.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    void delete(Integer id);

    List<User> findByName(String name);
}
