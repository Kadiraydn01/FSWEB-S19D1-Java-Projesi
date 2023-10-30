package com.example.film.dto;

import lombok.Data;

import java.util.List;
@Data
public class MovieResponse {
    private long id;
    private String name;
    private List<ActorResponse> actors;

    public MovieResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieResponse(long id, String name, List<ActorResponse> actors) {
        this.id = id;
        this.name = name;
        this.actors = actors;
    }
}
