package com.parim.model.Tiling;

public class Plant extends Enemy{
    private int numberOfCalls = 0;
    public Plant(int x, int y) {
        super(x, y, "/objects/Plant.png");
    }


    @Override
    public void move() {
        super.move();
        numberOfCalls++;
        if (((numberOfCalls/60) / 2) % 2 == 0)
            y++;
        else
            y--;
    }
}
