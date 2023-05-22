package com.example.lab11.Controller;

import com.example.lab11.Model.Game;
import com.example.lab11.Service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping("/games")
    public List<Game> getGameList() {
        return gameService.getGameList();
    }

    @PostMapping("/games")
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @PutMapping("/games/{id}")
    public void updateGame(@PathVariable int id, @RequestBody Game game) {
        gameService.updateGame(id, game);
    }

    @DeleteMapping("/games/{id}")
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }
}
