package com.parim.view.objects.gameObjects;

import com.parim.view.loaders.ImageLoader;

import java.awt.*;

public class PowerUpBlock extends Block {
    private static final Image powerUpBlockImage = new ImageLoader("objects/PowerUpBlock.png").getScaledPicture(width, height);

    public PowerUpBlock(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(powerUpBlockImage, x, y, null);
    }
}
