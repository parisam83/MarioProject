package com.parim.model.Tiling;

import com.parim.model.Mario;

public abstract class Tile {
    protected int x, y;
    protected final int width, height;
    protected Area area;
    protected final String directory;

    public Tile(int x, int y, String directory){
        this.x = x;
        this.y = y;
        this.directory = directory;
        width = height = 60;
        //this.area = new Area(x, y, width, height);
    }
    public Tile(int x, int y, int width, int height, String directory){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.directory = directory;
        //this.area = new Area(x, y, width, height);
    }

    public void move(){
        x -= Mario.getXVelocity();
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

    public Area getArea() {
        area = new Area(x, y, width, height);
        return area;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getDirectory() {
        return directory;
    }
}
