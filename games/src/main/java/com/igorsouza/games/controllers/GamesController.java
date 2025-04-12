package com.igorsouza.games.controllers;

import com.igorsouza.games.dtos.NewGame;
import com.igorsouza.games.exceptions.GameNotFoundException;
import com.igorsouza.games.models.Game;
import com.igorsouza.games.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

        return "games/index.html";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable UUID id) throws GameNotFoundException {
        Game game = gamesService.getGameById(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/new")
    public ResponseEntity<Game> createGame(@RequestBody NewGame newGame) {
        Game game = gamesService.saveGame(newGame);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable UUID id) throws GameNotFoundException {
        gamesService.deleteGame(id);
        return ResponseEntity.ok("Game successfully deleted.");
    }
}
