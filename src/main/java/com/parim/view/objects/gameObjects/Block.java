package com.parim.view.objects.gameObjects;

import com.parim.model.Tiling;

import java.awt.*;

public abstract class Block {
    protected int x, y;
    protected static int width = Tiling.getObjectSize(), height = Tiling.getObjectSize();
    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(){
        x -= Mario.getXVelocity();
    }
    public abstract void draw(Graphics g);

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
