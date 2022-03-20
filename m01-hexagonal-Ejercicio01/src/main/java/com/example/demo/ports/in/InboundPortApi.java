package com.example.demo.ports.in;

import com.example.demo.core.domain.exception.NotFoundException;
import com.example.demo.core.domain.exception.RepositoryNotRespondingException;
import com.example.demo.core.domain.model.Pokemon;

public interface InboundPortApi {

    Pokemon execute(String pokemonId ) throws RepositoryNotRespondingException, NotFoundException;
}
