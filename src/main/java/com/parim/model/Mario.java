package com.parim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Mario {
    @JsonIgnore
    private Game game;
    private int x, y, firstY;
    private static int xVelocity, yVelocity;
    private static int speed = 8, diff = 240+20;
    private static int size = 80;
    private String directory;
    private Character character;
    private boolean gravity = false, jump = false, intersectDown = true;

    public Mario(){}
    public Mario(int x, int y, Character character, Game game){
        this.x = x;
        this.y = y;
        this.game = game;
        this.character = character;
        this.directory = "/characters/" + character.name() + ".png";
        xVelocity = yVelocity = 0;
    }

    public void move(){
        if (game.intersectDown() && yVelocity > 0) {
            gravity = false;
            jump = false;
            yVelocity = 0;
        }
        if (game.intersectRight() && xVelocity > 0){
            xVelocity = 0;
        }

        if (intersectDown && !game.intersectDown()){
            intersectDown = false;
            if (!jump) {
                gravity = true;
                yVelocity = speed;
            }
        }

        if (gravity && !jump && !intersectDown)
            yVelocity = speed;

        if ((xVelocity > 0 && game.intersectRight()) || (xVelocity < 0 && game.intersectLeft()))
            xVelocity = 0;
        if (yVelocity > 0 && game.intersectDown()) {
            yVelocity = 0;
            intersectDown = true;
            gravity = false;
        }
        if (game.intersectUp()) {
            jump = false;
            gravity = true;
        }

        intersectDown = game.intersectDown();
        if (!jump && !gravity) yVelocity = 0;
        if (jump) yVelocity = -Math.abs(yVelocity);
        if (gravity) yVelocity = Math.abs(yVelocity);
        if (jump && y <= firstY - diff) {
            gravity = true;
            jump = false;
        }
        x += xVelocity;
        y += yVelocity;
        game.checkMarioLocation();
    }

    public static int getSize() {
        return size;
    }

    public static int getSpeed() {
        return speed;
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

    public static int getXVelocity() {
        return xVelocity;
    }

    public static void setXVelocity(int xVelocity) {
        Mario.xVelocity = xVelocity;
    }

    public static int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        if (Mario.yVelocity == 0 && yVelocity < 0) {
            firstY = y;
            jump = true;
            gravity = false;
        }
        Mario.yVelocity = yVelocity;
    }

    public Character getCharacter() {
        return character;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public int getFirstY() {
        return firstY;
    }

    public void setFirstY(int firstY) {
        this.firstY = firstY;
    }

    public static int getxVelocity() {
        return xVelocity;
    }

    public static void setxVelocity(int xVelocity) {
        Mario.xVelocity = xVelocity;
    }

    public static int getyVelocity() {
        return yVelocity;
    }

    public static void setyVelocity(int yVelocity) {
        Mario.yVelocity = yVelocity;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isGravity() {
        return gravity;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isIntersectDown() {
        return intersectDown;
    }

    public void setIntersectDown(boolean intersectDown) {
        this.intersectDown = intersectDown;
    }
}
