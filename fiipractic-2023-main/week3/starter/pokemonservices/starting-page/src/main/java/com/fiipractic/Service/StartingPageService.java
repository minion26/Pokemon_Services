package com.fiipractic.Service;

import com.fiipractic.Model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StartingPageService {

    //imi da id-ul pokemonului dupa numele introdus
    public Integer getIdFromName(String name){
        RestTemplate restTemplate = new RestTemplate();
        //ma folosec de pokedex service ca sa imi dea id-ul pokemonului
        Pokemon[] pokemon = restTemplate.getForObject(
                "http://localhost:8081/pokedex?search=" + name,
                Pokemon[].class);

        assert pokemon != null;
        System.out.println("the id is: " + pokemon[0].getId());
        return pokemon[0].getId();
    }

}
