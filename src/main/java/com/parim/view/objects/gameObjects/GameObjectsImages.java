package com.parim.view.objects.gameObjects;


import com.parim.model.Mario;
import com.parim.model.Tiling.Tile;
import com.parim.view.loaders.ImageLoader;

import java.awt.*;
import java.util.HashMap;

public class GameObjectsImages {
    private static HashMap<String, Image> images = new HashMap<>();
    private static Image marioImage;
    public static Image getImage(Tile tile){
        String directory = tile.getDirectory();
        if (images.get(directory) == null)
            images.put(directory, new ImageLoader(directory).getScaledPicture(tile.getWidth(), tile.getWidth()));
        return images.get(directory);
    }
    public static Image getImage(Mario mario){
        if (marioImage == null) marioImage = mario.getCharacter().getPicture().getScaledPicture(Mario.getSize(), Mario.getSize());
        return marioImage;
    }
}
