package com.parim.model;

public class Score {
    private int totalScore = 0;

    public void addCoin(){
        totalScore += 10;
    }
    public void addHeart(){
        totalScore += 20;
    }
    public void addEnemy(){
        totalScore += 15;
    }
    public void addTime(int timeLeft){
        totalScore += timeLeft;
    }
}
