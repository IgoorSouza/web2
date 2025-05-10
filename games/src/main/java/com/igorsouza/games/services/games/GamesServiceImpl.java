package com.igorsouza.games.services.games;

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
    public void saveGame(Game game) {
        gamesRepository.save(game);
    }

    @Override
    public Game getGameById(UUID id) throws GameNotFoundException {
        Optional<Game> game = gamesRepository.findById(id);

        if (game.isEmpty()) {
            throw new GameNotFoundException();
        }

        return game.get();
    }

    @Override
    public void deleteGame(UUID id) throws GameNotFoundException {
        boolean doesGameExist = gamesRepository.existsById(id);

        if (!doesGameExist) {
            throw new GameNotFoundException();
        }

        gamesRepository.deleteById(id);
    }
}
