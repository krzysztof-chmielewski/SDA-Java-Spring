package com.kchmielewski.sda.java.spring06java.player.web;

import com.kchmielewski.sda.java.spring06java.player.model.Player;
import com.kchmielewski.sda.java.spring06java.player.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ModelAttribute
    public Player defaultPlayer() {
        return new Player("Fill my name...", "...and my surname!");
    }

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("players", playerService.all());

        return "players";
    }

    @PostMapping("")
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
