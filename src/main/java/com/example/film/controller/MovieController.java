package com.example.film.controller;

import com.example.film.dto.ActorResponse;
import com.example.film.dto.MovieActorRequired;
import com.example.film.dto.MovieResponse;
import com.example.film.entity.Actor;
import com.example.film.entity.Movie;
import com.example.film.service.ActorService;
import com.example.film.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;
    private ActorService actorService;

    @Autowired
    public MovieController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }
    @GetMapping("/")
    public List<MovieResponse> findAll(){
        List<MovieResponse> movieResponse = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for (Movie movie : movies){
            movieResponse.add(new MovieResponse(movie.getId(), movie.getName()));
        }
        return movieResponse;
    }
    @PostMapping("/")
    public MovieResponse save(@RequestBody MovieActorRequired movieActorRequired) {
        Movie movie = movieActorRequired.getMovie();
        List<Actor> actorList = movieActorRequired.getActorList();

        if (actorList == null) {
            return new MovieResponse(movie.getId(), movie.getName());
        }
        for (Actor actor : actorList) {
            movie.addActor(actor);
        }

        Movie savedMovie = movieService.save(movie);
        return new MovieResponse(savedMovie.getId(), savedMovie.getName());
    }

    @GetMapping("/{movieId}")
    public MovieResponse find(@PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);

        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : movie.getActors()) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName()));
        }

        return new MovieResponse(movie.getId(), movie.getName(), actorResponses);
    }

    @PutMapping("/addActor/{movieId}")
    public MovieResponse addActor(@PathVariable int movieId, @RequestBody Actor actor) {
        Movie movie = movieService.findById(movieId);
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return new MovieResponse(savedMovie.getId(), savedMovie.getName());
    }
}