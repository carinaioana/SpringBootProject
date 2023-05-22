package com.example.lab11.Model;

public class Game {
    private int id;
    private String name;
    public Game(){

    }

    public Game(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters (if required)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
