package com.example.demo.core.domain.model.service;

import com.example.demo.core.domain.exception.NotFoundException;
import com.example.demo.core.domain.exception.RepositoryNotRespondingException;
import com.example.demo.core.domain.model.Id;
import com.example.demo.core.domain.model.Pokemon;
import com.example.demo.ports.out.PokemonRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PokemonFinder {

    private final PokemonRepository repository;

    public PokemonFinder(PokemonRepository repository) {
        this.repository = repository;
    }

    public Pokemon find(String id) throws RepositoryNotRespondingException, NotFoundException {

        Optional<Pokemon> pokemonInformation = repository.getPokemonInformation(new Id(Integer.valueOf(id)));

        if(pokemonInformation.isPresent()){
            return pokemonInformation.get();
        }else{
            throw new NotFoundException("Id not found");
        }
    }
}
