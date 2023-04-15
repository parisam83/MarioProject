package com.parim.model;

import java.util.ArrayList;

public class User {
    private int id;
    private int maxScore, coins;
    private String username, password;
    private Character currentCharacter = Character.Xayyat;
    private ArrayList<Game> savedGames = new ArrayList<>();
    private ArrayList<Character> characters = new ArrayList<Character>(){{add(Character.Xayyat);}};

    public User(){}
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
    public void setCurrentCharacter(Character character){
        this.currentCharacter = character;
    }
    public void addCharacter(Character character){
        this.characters.add(character);
    }
    public void addGame(int indexToDelete, Game gameToAdd){
        if (indexToDelete >= 0 && indexToDelete < savedGames.size()) savedGames.remove(indexToDelete);
        savedGames.add(gameToAdd);
    }
    public void addGame(Game gameToDelete, Game gameToAdd){
        if (gameToDelete != null) savedGames.remove(gameToDelete);
        if (gameToAdd !=  null) savedGames.add(gameToAdd);
    }
    public Game GetLastAddedGame(){
        if (savedGames.size() > 0) return savedGames.get(savedGames.size() - 1);
        return null;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSavedGames(ArrayList<Game> savedGames) {
        this.savedGames = savedGames;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public void setId(int id) {
        this.id = id;
    }
}
