package com.example.demo.core.usecase;

import com.example.demo.core.domain.exception.NotFoundException;
import com.example.demo.core.domain.exception.RepositoryNotRespondingException;
import com.example.demo.core.domain.model.Pokemon;
import com.example.demo.core.domain.model.service.PokemonFinder;
import com.example.demo.ports.in.InboundPortApi;
import org.springframework.stereotype.Service;

@Service
public class GetPokemonInformationUseCase implements InboundPortApi {

    final private PokemonFinder finder;

    public GetPokemonInformationUseCase(PokemonFinder finder) {
        this.finder = finder;
    }

    public Pokemon execute(String pokemonId ) throws RepositoryNotRespondingException, NotFoundException {

        return finder.find(pokemonId);
    }
}
