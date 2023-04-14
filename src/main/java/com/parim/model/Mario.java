package com.parim.model;

public class Mario {
    transient private Game game;
    private int x, y, firstY, xDraw;
    private static int xVelocity, yVelocity;
    private static final int speed = 8, diff = 240+20;
    private static final int size = 80;
    private final String directory;
    private final Character character;
    private boolean gravity = false, jump = false, intersectDown = true;
    public Mario(int x, int y, Character character, Game game){
        this.x = xDraw = x;
        this.y = y;
        this.game = game;
        this.character = character;
        this.directory = "/characters/" + character.name() + ".png";
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
}
