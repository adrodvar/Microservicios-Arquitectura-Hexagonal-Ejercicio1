package com.example.demo.adapters.in.api;

import com.example.demo.adapters.in.api.dto.PokemonInformationResponse;

import com.example.demo.core.domain.exception.NotFoundException;
import com.example.demo.core.domain.exception.RepositoryNotRespondingException;
import com.example.demo.core.domain.model.Pokemon;
import com.example.demo.core.usecase.GetPokemonInformationUseCase;
import com.example.demo.ports.in.InboundPortApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApIRestController {


    final private InboundPortApi useCase;


    public ApIRestController(GetPokemonInformationUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping( path = "/{pokemonId}", produces = "application/json")
    public @ResponseBody
    ResponseEntity<PokemonInformationResponse> GetPokemonInformation(@PathVariable String pokemonId) throws RepositoryNotRespondingException, NotFoundException {

        Pokemon pokemon = useCase.execute(pokemonId);

        return ResponseEntity.ok(new PokemonInformationResponse(
                pokemon.getId().getValue(),
                pokemon.getName().getValue(),
                pokemon.getWeight().getValue(),
                pokemon.getHeight().getValue()
        ));

    }
}
