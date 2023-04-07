package com.parim.model;

import com.parim.view.loaders.ImageLoader;

public enum Character {
    Xayyat(0, new ImageLoader("Xayyat.png")),
    Frog(100, new ImageLoader("Frog.png")), // jump
    MigMig(200, new ImageLoader("MigMig.png")), // fast
    Woman(750, new ImageLoader("Woman.png")), // coin
    RobinHood(400, new ImageLoader("RobinHood.png")) // shot
    ;

    private final int price;
    private final ImageLoader picture;
    Character(int price, ImageLoader picture){
        this.price = price;
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }
    public ImageLoader getPicture() {
        return picture;
    }
}