package com.example.ss15.service;

import com.example.ss15.model.CV;

import java.util.List;

public interface CVService {
    List<CV> findAll();
    CV findById(Long id);
    CV save(CV resume);
    void deleteById(Long id);
}

