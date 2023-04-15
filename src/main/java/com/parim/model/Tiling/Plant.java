package com.parim.model.Tiling;

public class Plant extends Enemy{
    private int numberOfCalls = 0;
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
        //System.out.println(numberOfCalls + " : " + y);
    }

    public void updateNumberOfCalls() {
        this.numberOfCalls++;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }
}
