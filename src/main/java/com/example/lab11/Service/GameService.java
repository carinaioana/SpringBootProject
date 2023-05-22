package com.example.lab11.Service;

import com.example.lab11.Model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private List<Game> gameList;

    public GameService() {
        gameList = new ArrayList<>();
        gameList.add(new Game(1, "Game 1"));
        gameList.add(new Game(2, "Game 2"));
        // Add more games as needed
    }
    public List<Game> getGameList() {
        return gameList;
    }

    public void addGame(Game game) {
        gameList.add(game);
    }

    public void updateGame(int id, Game updatedGame) {
        for (Game game : gameList) {
            if (game.getId() == id) {
                game.setName(updatedGame.getName());
                break;
            }
        }
    }

    public void deleteGame(int id) {
        gameList.removeIf(game -> game.getId() == id);
    }
}
