package com.example.film.service;

import com.example.film.entity.Actor;
import com.example.film.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService
{
    private ActorRepository actorRepository;
@Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        return optionalActor.orElse(null);

    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor delete(long id) {
    Actor actor = findById(id);
    actorRepository.delete(actor);
        return actor;
    }
}
