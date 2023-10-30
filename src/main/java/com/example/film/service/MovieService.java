package com.example.film.service;

import com.example.film.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(long id);
    Movie save(Movie movie);
    Movie delete (long id);
}
