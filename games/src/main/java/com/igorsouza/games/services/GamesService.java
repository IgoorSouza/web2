package com.igorsouza.games.services;

import com.igorsouza.games.exceptions.GameNotFoundException;
import com.igorsouza.games.models.Game;

import java.util.List;
import java.util.UUID;

public interface GamesService {

    List<Game> getAllGames();
    void saveGame(Game game);
    Game getGameById(UUID id) throws GameNotFoundException;
    void deleteGame(UUID id) throws GameNotFoundException;
}
