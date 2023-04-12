package com.parim.model.Tiling;

public class Area {
    private int up, down, left, right;
    public Area(int x, int y, int width, int height){
        up = y;
        down = y + height;
        left = x;
        right = x + width;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
