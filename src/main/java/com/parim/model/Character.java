package com.parim.model;

import com.parim.view.loaders.ImageLoader;

public enum Character {
    Xayyat(0, new ImageLoader("characters/Xayyat.png")),
    Frog(90, new ImageLoader("characters/Frog.png")), // jump
    MigMig(230, new ImageLoader("characters/MigMig.png")), // fast
    Woman(750, new ImageLoader("characters/Woman.png")), // coin
    RobinHood(410, new ImageLoader("characters/RobinHood.png")) // shot
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