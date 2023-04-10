package com.parim.view.objects.gameObjects;

import com.parim.view.loaders.ImageLoader;

import java.awt.*;

public class OrdinaryBlock extends Block {
    private static final Image ordinaryBlockImage = new ImageLoader("objects/OrdinaryBlock.png").getScaledPicture(width, height);

    public OrdinaryBlock(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ordinaryBlockImage, x, y, null);
    }
}
