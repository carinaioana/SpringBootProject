package com.example.lab11.Service;

import com.example.lab11.Model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private List<Player> playerList;

    public PlayerService() {
        playerList = new ArrayList<>();
        playerList.add(new Player(1, "Andrei"));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public void updatePlayer(int id, Player updatedPlayer) {
        for (Player player : playerList) {
            if (player.getId() == id) {
                player.setName(updatedPlayer.getName());
                break;
            }
        }
    }

    public void deletePlayer(int id) {
        playerList.removeIf(player -> player.getId() == id);
    }
}
