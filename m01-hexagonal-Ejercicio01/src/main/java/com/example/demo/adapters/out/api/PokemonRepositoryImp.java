package com.example.demo.adapters.out.api;

import com.example.demo.core.domain.exception.NotFoundException;
import com.example.demo.core.domain.exception.RepositoryNotRespondingException;
import com.example.demo.core.domain.model.Id;
import com.example.demo.core.domain.model.Pokemon;
import com.example.demo.ports.out.PokemonRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Repository
public class PokemonRepositoryImp implements PokemonRepository {

    private final static String URL = "https://pokeapi.co/api/v2/pokemon/";

    public Optional<Pokemon> getPokemonInformation(Id pokemonId) throws RepositoryNotRespondingException, NotFoundException {

        HttpResponse<String> response = null;
        try {

            HttpClient httpClient = HttpClient.newBuilder().build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(URL + pokemonId.getValue()))
                    .GET()
                    .build();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == HttpStatus.NOT_FOUND.value()) {
                return Optional.empty();
            }

            com.example.demo.adapters.out.api.dto.Pokemon pokemon = mapper.readValue(response.body(), com.example.demo.adapters.out.api.dto.Pokemon.class);

            Pokemon pokemonResponse = new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getWeight(), pokemon.getHeight());
            return Optional.of(pokemonResponse);

        } catch (IOException e) {
            throw new RepositoryNotRespondingException("Error with Api Communication");
        } catch (InterruptedException e) {
            throw new RepositoryNotRespondingException("Error with Api Communication");
        } catch (URISyntaxException e) {
            throw new RepositoryNotRespondingException("Error creating url");
        }

    }
}


