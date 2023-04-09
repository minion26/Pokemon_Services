package com.fiipractic.Service;


import com.fiipractic.Model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class WhosThatPokemonService {

    public Pokemon getRandomPokemon(){
        RestTemplate restTemplate = new RestTemplate();
        Pokemon[] pokemon = restTemplate.getForObject(
                "http://localhost:8081/pokedex/random?limit=" + 1,
                Pokemon[].class);


        return pokemon[0];
    }

    public Pokemon getPokemonById(Integer pokemonId){
        RestTemplate restTemplate = new RestTemplate();
        Pokemon pokemon = restTemplate.getForObject(
                "http://localhost:8081/pokedex/pokemon/" + pokemonId,
                Pokemon.class);

        return pokemon;
    }
}
