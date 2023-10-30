package com.example.film.dto;

import com.example.film.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieActorResponse {
    private Movie movie;
    private long actorId;
    private String actorFirstName;
    private String actorLastName;
}
