package com.fiipractic.Controller;

import com.fiipractic.Service.StartingPageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartingPageController {
    private final StartingPageService startingPageService;
    //dependency injection
    public StartingPageController(StartingPageService startingPageService) {
        this.startingPageService = startingPageService;
    }

    @GetMapping(value="/")
    public String startingPage(){

        return "starting-page";
    }

    @PostMapping(value="/breed")
    public String breed(@RequestParam String name1, @RequestParam String name2, Model model){
        //imi trebuie idul pokemonului 1 si 2
        Integer pokeId1 = startingPageService.getIdFromName(name1);
        Integer pokeId2 = startingPageService.getIdFromName(name2);

        System.out.println(pokeId1);
        System.out.println(pokeId2);

        model.addAttribute("pokeId1", pokeId1);
        model.addAttribute("pokeId2", pokeId2);

        return "starting-page";
    }
}
