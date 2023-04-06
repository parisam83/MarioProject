package com.parim.model;

import com.parim.access.UserAccess;

import java.util.ArrayList;

public class User {
    private final int id;
    private  int maxScore, coins;
    private String username, password;
    private Character currentCharacter = Character.Xayyat;
    private ArrayList<Game> savedGames = new ArrayList<>();
    private ArrayList<Character> characters = new ArrayList<Character>(){{add(Character.Xayyat);}};

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void changeCharacter(Character character){
        this.currentCharacter = character;
    }
    public void addCharacter(Character character){
        this.characters.add(character);
    }
    public void addGame(Game game){
        if (savedGames.size() == 3)
            savedGames.remove(0);
        savedGames.add(game);
    }
    public void addCoins(int coins){
        this.coins += coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public int getCoins() {
        return coins;
    }
    public void setMaxScore(int maxScore) {
        this.maxScore = Math.max(maxScore, this.maxScore);
    }
    public int getMaxScore() {
        return maxScore;
    }

    public Character getCurrentCharacter() {
        return currentCharacter;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<Game> getSavedGames() {
        return savedGames;
    }
}
