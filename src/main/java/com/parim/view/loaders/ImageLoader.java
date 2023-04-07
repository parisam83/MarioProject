package com.parim.view.loaders;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    private final Image picture;
    private final ImageIcon small, big;
    public ImageLoader(String name){
        {
            try {
                picture = ImageIO.read(new File("src/main/resources/characters/" + name));
                big = new ImageIcon(picture.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
                small = new ImageIcon(picture.getScaledInstance(190, 190, Image.SCALE_SMOOTH));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Image getPicture() {
        return picture;
    }
    public ImageIcon getSmall() {
        return small;
    }
    public ImageIcon getBig() {
        return big;
    }
}
