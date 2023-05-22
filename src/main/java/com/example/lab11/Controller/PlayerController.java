package com.example.lab11.Controller;

import com.example.lab11.Model.Player;
import com.example.lab11.Service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    public PlayerController( PlayerService playerService){
        this.playerService = playerService;
    }
    @RequestMapping("/players")
    public List<Player> playerList (){
        return playerService.getPlayerList();
    }
    @PostMapping("/players")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @PutMapping("players/{id}")
    public void updatePlayer(@PathVariable int id, @RequestBody Player player) {
        playerService.updatePlayer(id, player);
    }

    @DeleteMapping("players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}
