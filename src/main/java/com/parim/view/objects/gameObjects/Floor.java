package com.parim.view.objects.gameObjects;

import com.parim.model.Tiling;
import com.parim.view.loaders.ImageLoader;

import java.awt.*;

public class Floor {
    private int x, y;
    private static int width = Tiling.getObjectSize(), height = Tiling.getObjectSize();
    private static final Image floorImage = new ImageLoader("objects/Floor.png").getScaledPicture(width, height);

    public Floor(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g){
        g.drawImage(floorImage, x, y, Tiling.getObjectSize(), Tiling.getObjectSize(), null);
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
