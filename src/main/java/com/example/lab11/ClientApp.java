package com.example.lab11;

import com.example.lab11.Model.Player;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ClientApp {
    public void run(){
        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create HttpHeaders with Content-Type header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a new player
        Player newPlayer = new Player(3, "Stefan");

        // Add a player
        String addPlayerUrl = "http://localhost:8090/players";
        HttpEntity<Player> addPlayerRequest = new HttpEntity<>(newPlayer, headers);
        restTemplate.postForObject(addPlayerUrl, addPlayerRequest, Void.class);

        // Update a player
        String updatePlayerUrl = "http://localhost:8090/players/3";
        Player updatedPlayer = new Player(2, "Andrada");
        HttpEntity<Player> updatePlayerRequest = new HttpEntity<>(updatedPlayer, headers);
        restTemplate.exchange(updatePlayerUrl, HttpMethod.PUT, updatePlayerRequest, Void.class);

        // Get the list of players
        String getPlayersUrl = "http://localhost:8090/players";
        Player[] players = restTemplate.getForObject(getPlayersUrl, Player[].class);
        if (players != null) {
            for (Player player : players) {
                System.out.println("Player ID: " + player.getId() + ", Name: " + player.getName());
            }
        }

    }
    public static void main(String[] args) {
        ClientApp clientApp = new ClientApp();
        clientApp.run();
    }

}
