package com.example.demo.ports.out;

import com.example.demo.core.domain.exception.NotFoundException;
import com.example.demo.core.domain.exception.RepositoryNotRespondingException;
import com.example.demo.core.domain.model.Id;
import com.example.demo.core.domain.model.Pokemon;

import java.util.Optional;

public interface PokemonRepository {

    public Optional<Pokemon> getPokemonInformation(Id pokemonId) throws RepositoryNotRespondingException, NotFoundException;
}
