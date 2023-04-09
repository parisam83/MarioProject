package com.parim.model;

import java.util.ArrayList;

public class Game {
    private Character character;
    private int x, y; // TODO: وقتی از بازی میخواست بیاد بیرون سیوش کن
    private int hearts = 3;
    private int totalCoins = 0, totalScore = 0;
    private String currentState;
    private ArrayList<Level> levels;

    public Game(Character character){
        this.character = character;
    }
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getHearts() {
        return hearts;
    }

    public void reduceHearts() {
        this.hearts--;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void addTotalCoins(int amount) {
        this.totalCoins += amount;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addTotalScore(int amount) {
        this.totalScore += amount;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public String getCurrentState() {
        return currentState;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
