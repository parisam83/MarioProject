package com.parim.view.objects.gameObjects;

import com.parim.model.Character;
import com.parim.model.Tiling;

import java.awt.*;

public class Mario {
    private int x, y;
    private static int width = Tiling.getMarioSize(), height = Tiling.getMarioSize();

    private static int xVelocity = 0, yVelocity = 0, speed = 10;
    private Character character;
    private final Image characterImage;
    private boolean gravity = false;

    public Mario(int x, int y, Character character){
        this.x = x;
        this.y = y;
        this.character = character;
        characterImage = character.getPicture().getScaledPicture(width, height);
    }

    public void move(){
        if (y <= 452 - Tiling.getMarioSize() - 10) gravity = true;
        x += xVelocity;
        if (gravity) y -= yVelocity;
        else y += yVelocity;
        if (y >= 692 - Tiling.getMarioSize()){
            gravity = false;
            yVelocity = 0;
        }
    }

    public void draw(Graphics g){
        g.drawImage(characterImage, x, y, width, height, null);
    }

    public static void setXVelocity(int xVelocity) {
        Mario.xVelocity = xVelocity;
    }

    public static void setYVelocity(int yVelocity) {
        Mario.yVelocity = yVelocity;
    }

    public static int getXVelocity() {
        return xVelocity;
    }

    public static int getYVelocity() {
        return yVelocity;
    }

    public static int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
