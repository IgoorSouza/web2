package com.igorsouza.games.controllers;

import com.igorsouza.games.exceptions.GameNotFoundException;
import com.igorsouza.games.models.Game;
import com.igorsouza.games.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public String getGames(Model model) {
        List<Game> games = gamesService.getAllGames();
        model.addAttribute("games", games);

        return "games/index";
    }

    @GetMapping ("/create")
    public String create(Model model) {
        model.addAttribute("game", new Game());
        return "games/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable UUID id, Model model) throws GameNotFoundException {
        Game game = gamesService.getGameById(id);
        model.addAttribute("game", game);
        return "games/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) throws GameNotFoundException {
        gamesService.deleteGame(id);
        return "redirect:/games";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Game game) {
        gamesService.saveGame(game);
        return "redirect:/games";
    }
}
