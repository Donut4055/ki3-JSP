package com.example.ss19.service;


import com.example.ss19.entity.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> findAll();
    Theater findById(Long id);
    void save(Theater theater);
    void update(Theater theater);
    void delete(Long id);
    List<Theater> findByStatus(Boolean status);
}

