package com.example.ss19.service;


import com.example.ss19.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void delete(Long id);
    List<Movie> findByStatus(Boolean status);
}

