package com.parim.model.Tiling;

import com.parim.model.Time;

public class Plant extends Enemy{
    public Plant(int x, int y) {
        super(x, y, "/objects/Plant.png");
    }


    @Override
    public void move() {
        super.move();
        if ((Time.getSec() / 2) % 2 == 0)
            y++;
        else
            y--;
    }
}
