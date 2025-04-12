package com.igorsouza.games.services;

import com.igorsouza.games.dtos.NewGame;
import com.igorsouza.games.exceptions.GameNotFoundException;
import com.igorsouza.games.models.Game;
import com.igorsouza.games.repositories.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;

    @Override
    public List<Game> getAllGames() {
        return gamesRepository.findAll();
    }

    @Override
    public Game saveGame(NewGame newGame) {
        Game game = Game.builder()
                .name(newGame.getName())
                .description(newGame.getDescription())
                .price(newGame.getPrice())
                .build();

        return gamesRepository.save(game);
    }

    @Override
    public Game getGameById(UUID id) throws GameNotFoundException {
        Optional<Game> game = gamesRepository.findById(id);

        if (game.isEmpty()) {
            throw new GameNotFoundException("Game with id" + id + " not found");
        }

        return game.get();
    }

    @Override
    public void deleteGame(UUID id) throws GameNotFoundException {
        boolean doesGameExist = gamesRepository.existsById(id);

        if (!doesGameExist) {
            throw new GameNotFoundException("Game with id" + id + " not found");
        }

        gamesRepository.deleteById(id);
    }
}
