package com.example.film.dto;

import com.example.film.entity.Actor;
import com.example.film.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieActorRequired {
    private List<Actor>actorList;
    private Movie movie;
}
