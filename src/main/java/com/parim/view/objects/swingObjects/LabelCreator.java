package com.parim.view.objects.swingObjects;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class LabelCreator extends JLabel {
    private int x = 0, y = 20;
    private Font font = FontLoader.titleFont;
    private final String text;
    public LabelCreator(String text){
        this.text = text;
        createLabel();
    }
    public LabelCreator(String text, Font font){
        this.text = text;
        this.font = font;
        createLabel();
    }
    public LabelCreator(int x, int y, String text, Font font){
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = font;
        createLabel();
    }
    public void createLabel(){
        this.setText(text);
        this.setFont(font);
        this.setBounds(x, y, MainFrame.getGameWidth(), MainFrame.getGameHeight());
        if (font != FontLoader.titleFont)
            this.setBounds(x, y, 200, 100);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}