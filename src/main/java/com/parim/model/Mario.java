package com.parim.model;

public class Mario {
    private int x, y, firstY;
    private static int xVelocity, yVelocity;
    private static final int speed = 8, diff = 240+20;
    private static final int size = 80;
    private final String directory;
    private final Character character;
    private boolean gravity = false, jump = false;
    public Mario(int x, int y, Character character){
        this.x = x;
        this.y = y;
        //area = new Area(x, y, size, size);
        this.character = character;
        this.directory = "/characters/" + character.name() + ".png";
    }

    public void move(){
        Scene scene = Scene.getInstance();
        if (gravity) yVelocity = speed;
        if (jump) yVelocity = -speed;
        if ((xVelocity > 0 && !scene.intersectRight()) || (xVelocity < 0 && !scene.intersectLeft()))
            x += xVelocity;
        if ((yVelocity > 0 && !scene.intersectDown()) || (yVelocity < 0 && !scene.intersectUp()))
            y += yVelocity;

        if (jump && y <= firstY - diff) {
            gravity = true;
            jump = false;
        }
        if (scene.intersectUp()){
            gravity = true;
            jump = false;
        }
        if (scene.intersectDown())
            yVelocity = 0;
        if (scene.intersectRight() || scene.intersectLeft())
            xVelocity = 0;
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
        if (Mario.yVelocity == 0 && yVelocity != 0) {
            firstY = y;
            jump = true;
            gravity = false;
        }
        Mario.yVelocity = yVelocity;
    }

    public Character getCharacter() {
        return character;
    }
}
