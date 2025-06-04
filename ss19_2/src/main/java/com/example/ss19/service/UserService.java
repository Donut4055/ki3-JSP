package com.example.ss19.service;


import com.example.ss19.entity.User;

import java.util.List;

public interface UserService {
    void update(User customer);
    User findById(Integer id);

    List<User> findAllWithPagination(int page, int size, String search);
    long countWithSearch(String search);
    long countAll();
}

