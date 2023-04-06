package com.parim.view.loaders;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    private final Image picture;

    ImageLoader(String name){
        {
            try {
                picture = ImageIO.read(new File("src/main/resources/characters/" + name));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Image getPicture() {
        return picture;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(picture);
    }
}
