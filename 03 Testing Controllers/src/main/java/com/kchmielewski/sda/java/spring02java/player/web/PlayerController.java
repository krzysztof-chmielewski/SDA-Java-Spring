package com.kchmielewski.sda.java.spring02java.player.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PlayerController {
    private final List<String> players;

    public PlayerController() {
        players = new ArrayList<>();
        players.addAll(Arrays.asList("Adam Lallana", "Philippe Coutinho"));
    }

    @GetMapping("display")
    public String display(Model model) {
        model.addAttribute("players", players);

        return "players";
    }

    @PostMapping("add")
    public String add(@RequestParam String name, @RequestParam("myVeryStrangeParameterName") String surname, Model model) {
        players.add(name + " " + surname);
        model.addAttribute("players", players);

        return "players";
    }

    @PostMapping("remove")
    public String remove(@RequestParam String name, @RequestParam String surname, Model model) {
        players.remove(name + " " + surname);
        model.addAttribute("players", players);

        return "players";
    }

    @GetMapping("extremelyFancyMethodMapingWithEvenMoreFancyEverythingAndNothingAtTheSameTime")
    public String doSomethingSpecial(Model model) {
        model.addAttribute("players", players);

        return "players";
    }
}
