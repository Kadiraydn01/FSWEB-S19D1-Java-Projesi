package com.example.film.service;

import com.example.film.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(long id);
    Actor save(Actor actor);
    Actor delete(long id);

}
