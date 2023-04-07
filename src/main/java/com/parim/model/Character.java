package com.parim.model;

import com.parim.view.loaders.ImageLoader;

import javax.swing.*;

public enum Character {
    Xayyat(0, new ImageLoader("Xayyat.png").getIcon()),
    Frog(100, new ImageLoader("Frog.png").getIcon()), // jump
    MigMig(200, new ImageLoader("MigMig.png").getIcon()), // fast
    Woman(300, new ImageLoader("Woman.png").getIcon()), // coin
    RobinHood(400, new ImageLoader("RobinHood.png").getIcon()) // shot
    ;

    private final int price;
    private final ImageIcon imageIcon;
    Character(int price, ImageIcon imageIcon){
        this.price = price;
        this.imageIcon = imageIcon;
    }

    public int getPrice() {
        return price;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}