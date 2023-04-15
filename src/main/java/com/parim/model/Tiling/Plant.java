package com.parim.model.Tiling;

public class Plant extends Enemy{
    private int numberOfCalls = 0;
    public Plant(){}
    public Plant(int x, int y) {
        super(x, y, "/objects/Plant.png");
    }

    @Override
    public void move() {
        super.move();
        if ((numberOfCalls/120) % 2 == 0)
            y++;
        else
            y--;
        if (numberOfCalls == 240) numberOfCalls = 0;
        numberOfCalls++;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }
    public void updateNumberOfCalls() {
        this.numberOfCalls++;
    }
    public int getNumberOfCalls() {
        return numberOfCalls;
    }
}
