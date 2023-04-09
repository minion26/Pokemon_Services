package com.fiipractic.battle.service;

import com.fiipractic.pokemoncatalog.model.Pokemon;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BattleService {
    public String battle(Model model) {
        List<Pokemon> team1 = this.getTeam(5);
        List<Pokemon> team2 = this.getTeam(5);


        model.addAttribute("team1", team1);
        model.addAttribute("team2", team2);


        if (getTeamPower(team1) > getTeamPower(team2)) {
            System.out.println("Team 1 won !");
            model.addAttribute("winner", team1);
            return "Team 1 won !";
        } else {
            if (getTeamPower(team1) < getTeamPower(team2)) {
                System.out.println("Team 2 won !");
                model.addAttribute("winner", team2);
                return "Team 2 won !";
            }else{
                System.out.println("It's equal");
            }
        }

        return "";
    }

    private List<Pokemon> getTeam(Integer teamSize){
        RestTemplate restTemplate = new RestTemplate();
        Pokemon[] reponse = restTemplate.getForObject(
                "http://localhost:8081/pokedex/random?limit=" + teamSize,
                Pokemon[].class);

        List<Pokemon> team = Arrays.stream(reponse).toList();
        return team;
    }

    private Integer getTeamPower(List<Pokemon> team){
        int sum = 0;
        for(Pokemon poke : team){
            sum = sum + poke.getBaseTotal();
        }

        return sum;
    }
}
