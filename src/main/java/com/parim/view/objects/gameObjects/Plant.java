package com.parim.view.objects.gameObjects;

import com.parim.view.loaders.ImageLoader;


public class Plant extends Enemy{
    public Plant(int x, int y) {
        super(x, y);
        image = new ImageLoader("objects/Plant.png").getScaledPicture(width, height);
    }
    public void move(){
        x -= Mario.getXVelocity();
    }
}
