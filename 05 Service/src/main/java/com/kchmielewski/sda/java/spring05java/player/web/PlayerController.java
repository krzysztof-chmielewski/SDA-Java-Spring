package com.kchmielewski.sda.java.spring05java.player.web;

import com.kchmielewski.sda.java.spring05java.player.model.Player;
import com.kchmielewski.sda.java.spring05java.player.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("display")
    public String display(Model model) {
        model.addAttribute("players", playerService.all());

        return "players";
    }

    @PostMapping("add")
    public String add(@ModelAttribute Player player, Model model) {
        playerService.add(player);
        model.addAttribute("players", playerService.all());

        return "players";
    }

    @PostMapping("remove")
    public String remove(@ModelAttribute Player player, Model model) {
        playerService.remove(player);
        model.addAttribute("players", playerService.all());

        return "players";
    }
}
