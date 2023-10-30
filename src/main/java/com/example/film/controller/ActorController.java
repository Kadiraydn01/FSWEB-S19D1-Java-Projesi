package com.example.film.controller;

import com.example.film.dto.ActorResponse;
import com.example.film.entity.Actor;
import com.example.film.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;
@Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
@GetMapping("/")
    public List<ActorResponse> findAll(){
    List<ActorResponse> actorResponses = new ArrayList<>();
    List<Actor> actors = actorService.findAll();
        for (Actor actor : actors){
            actorResponses.add(new ActorResponse(actor.getId(),actor.getFirstName(),actor.getLastName()));
        }
        return actorResponses;
    }
@GetMapping("/{id}")
    public ActorResponse findById(@PathVariable long id){
    Actor foundActor = actorService.findById(id);
    return new ActorResponse(foundActor.getId(), foundActor.getFirstName(), foundActor.getLastName());

}

  @DeleteMapping("/{id}")
    public ActorResponse remove(@PathVariable long id){
    Actor deletedActor = actorService.findById(id);
    return null;
  }

}
