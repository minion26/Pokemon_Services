package com.fiipractic.Controller;

import com.fiipractic.Model.Pokemon;
import com.fiipractic.Service.WhosThatPokemonService;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;

@Controller
//RestController returneaza Json si noi vrem HTML
public class WhosThatPokemonController {
    private final WhosThatPokemonService whosThatPokemonService;

    public WhosThatPokemonController(WhosThatPokemonService whosThatPokemonService) {
        this.whosThatPokemonService = whosThatPokemonService;
    }

    @GetMapping(value="/")
    public String whosThatPokemon(Model m){

        Pokemon pokemon = whosThatPokemonService.getRandomPokemon();
        m.addAttribute("pokemonIndex", pokemon.getId());

        return "whos-that-pokemon";
    }

    @PostMapping(value="/guess")
    public String guess(@RequestParam String guess, @RequestParam Integer pokemonIndex, Model model){

        System.out.println(guess);
        System.out.println(pokemonIndex);

        Pokemon pokemon = whosThatPokemonService.getPokemonById(pokemonIndex);
        System.out.println(pokemon);

        String result ="";
        if(guess.equalsIgnoreCase(pokemon.getName())){
            result="correct";
        }else{
            result="incorrect! correct answer is: " + pokemon.getName();
        }
        System.out.println(result);

        model.addAttribute("pokemonIndex", pokemonIndex);
        model.addAttribute("result", result);

        return "whos-that-pokemon";
    }
}
