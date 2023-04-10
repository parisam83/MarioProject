package com.parim.view.objects.gameObjects;

import com.parim.view.loaders.ImageLoader;

import java.awt.*;

public class Pipe {
    private int x, y, width, height;
    private Image image;
    public Pipe(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        image = new ImageLoader("objects/Pipe.png").getScaledPicture(width, height);
    }

    public void move(){
        x -= Mario.getXVelocity();
    }

    public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
