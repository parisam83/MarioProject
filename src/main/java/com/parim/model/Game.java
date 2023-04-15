package com.parim.model;

import com.parim.model.Tiling.*;
import com.parim.view.MainFrame;
import com.parim.view.objects.gameObjects.GameObjects;

import java.util.ArrayList;

public class Game {
    private Mario mario;
    private int hearts = 3;
    private int totalCoins = 0, totalScore = 0;
    private int sec = 0, lastSectionEnteringTime = 0, timeLimit = 40;
    private ArrayList<Tile> gameObjects = new GameObjects().getGameObjects();
    private int marioX = 150, marioY = 832 - 3 * 60 - Mario.getSize() + 40;
    private int maxMarioX = 150, lastSectionNumber = 1;
    private boolean gameEnded = false;

    public Game(Character character){
        mario = new Mario(150, MainFrame.getGameHeight() - Mario.getSize() - 140, character, this);
    }

    public boolean intersectUp(){
        boolean ans = false;
        for (Tile tile : gameObjects){
            Area area = tile.getArea();
            if ((marioX + Mario.getSize() > area.getLeft() && marioX < area.getRight()) &&
                (mario.getY() <= area.getDown() && mario.getY() >= area.getUp())) {
                if (tile instanceof PowerUpBlock && ((PowerUpBlock) tile).isCoinPowerUp()) {
                    updateCoinAndScore(5);
                    ((PowerUpBlock) tile).setCoinPowerUp(false);
                }
                checkTileIntersect(tile);
                if (tile instanceof Coin)
                    continue;
                ans = true;
            }
        }
        return ans;
    }
    public boolean intersectDown(){
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((marioX + Mario.getSize() > area.getLeft() && marioX < area.getRight()) &&
                (mario.getY() + Mario.getSize() <= area.getDown() && mario.getY() + Mario.getSize() >= area.getUp())) {
                checkTileIntersect(tile);
                if (tile instanceof Coin)
                    continue;
                mario.setY(area.getUp() - Mario.getSize());
                return true;
            }
        }
        return false;
    }
    public boolean intersectRight(){
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((mario.getY() + Mario.getSize() > area.getUp() && mario.getY() < area.getDown()) &&
                (marioX + Mario.getSize() >= area.getLeft() && marioX + Mario.getSize() <= area.getRight())) {
                checkTileIntersect(tile);
                if (tile instanceof Coin)
                    continue;
                return true;
            }
        }
        return false;
    }
    public boolean intersectLeft(){
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((mario.getY() + Mario.getSize() > area.getUp() && mario.getY() < area.getDown()) &&
                (marioX <= area.getRight()) && marioX >= area.getLeft()) {
                checkTileIntersect(tile);
                if (tile instanceof Coin)
                    continue;
                return true;
            }
        }
        return false;
    }

    public void checkTileIntersect(Tile tile){
        if (tile instanceof Enemy)
            die();
        if (tile instanceof Coin && ((Coin) tile).isVisible()) {
            ((Coin) tile).setVisible(false);
            updateCoinAndScore(1);
        }
    }
    public void checkMarioLocation(){
        if (mario.getY() > MainFrame.getGameHeight())
            die();
    }
    public void checkTime(){
        if (Time.getSec() - lastSectionEnteringTime >= timeLimit) {
            lastSectionEnteringTime = sec = Time.getSec();
            die();
        }
    }
    public void updateCoinAndScore(int amount){
        addTotalCoins(amount);
        addTotalScore(10 * amount);
    }

    public void die(){
        Mario.setXVelocity(-mario.getX() + 150);
        for (Tile tile : gameObjects)
            tile.move();

        maxMarioX = marioX;
        mario.setX(marioX);
        Mario.setXVelocity(0);

        mario.setY(marioY);
        mario.setYVelocity(0);

        reduceHearts();
        setTotalCoins(0);
        setTotalScore(0);
    }

    public void checkGameStatus(){
        gameEnded = true;
        if (mario.getX() >= 1500*8)
            winGame();
        else if (hearts == 0)
            loseGame();
        else
            gameEnded = false;
    }
    public void winGame(){
        Time.setSec(0);
        MainFrame.getInstance().setWinGamePage();
    }

    public void loseGame(){
        Time.setSec(0);
        MainFrame.getInstance().setLoseGamePage();
    }

    public int getCurrentLevel(){
        return mario.getX()/(8*MainFrame.getGameWidth()) + 1;
    }

    public int getCurrentSection(){
        return mario.getX()/(4*MainFrame.getGameWidth()) + 1 - 2*(getCurrentLevel() - 1);
    }

    public int getCurrentScene(){
        return mario.getX()/(MainFrame.getGameWidth()) + 1 - 4*(getCurrentSection() - 1) - 8*(getCurrentLevel() - 1);
    }
    public String calculateState(){
        int level = getCurrentLevel();
        int section = getCurrentSection();
        if (section != lastSectionNumber){
            totalScore += Math.max(0, timeLimit - Time.getSec() - lastSectionEnteringTime);
            totalScore += hearts * 20;
            lastSectionNumber = section;
            lastSectionEnteringTime = sec = Time.getSec();
        }
        int scene = getCurrentScene();
        return "" + level + "-" + section + "-" + scene;
    }

    public void reduceHearts() {
        hearts--;
    }
    public void addTotalCoins(int amount) {
        this.totalCoins += amount;
    }
    public void addTotalScore(int amount) {
        this.totalScore += amount;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(int totalCoins) {
        this.totalCoins = totalCoins;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public ArrayList<Tile> getGameObjects() {
        return gameObjects;
    }

    public void setMarioX(int marioX) {
        this.marioX = marioX;
    }

    public int getMarioX() {
        return marioX;
    }

    public int getMaxMarioX() {
        return maxMarioX;
    }

    public void setMaxMarioX(int maxMarioX) {
        this.maxMarioX = maxMarioX;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
}
