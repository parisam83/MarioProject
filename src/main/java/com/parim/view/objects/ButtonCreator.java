package com.parim.view.objects;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class ButtonCreator extends JButton {
    private static final int nextButtonWidth = 300, nextButtonHeight = 100;
    private static final int normalButtonWidth = 350, normalButtonHeight = 120;
    private int buttonWidth = 350, buttonHeight = 120;
    private int x = 0, y = 0;
    private final String text;
    private Font font = FontLoader.buttonFont;

    public ButtonCreator(String text, boolean nextButton){
        this.text = text;
        if (nextButton) nextButton();
        createButton();
    }
    public ButtonCreator(int y, String text, boolean nextButton){
        this.x = MainFrame.getGameWidth()/2 - buttonWidth/2;
        this.y = y;
        this.buttonWidth = normalButtonWidth;
        this.buttonHeight = normalButtonHeight;
        this.text = text;
        if (nextButton) nextButton();
        createButton();
    }
    public ButtonCreator(int x, int y, String text, boolean nextButton){
        this.x = x;
        this.y = y;
        this.text = text;
        if (nextButton) nextButton();
        createButton();
    }
    public ButtonCreator(int x, int y, String text, Font font, boolean nextButton){
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = font;
        if (nextButton) nextButton();
        createButton();
    }
    public ButtonCreator(int x, int y, int buttonWidth, int buttonHeight, String text, boolean nextButton){
        this.x = x;
        this.y = y;
        this.text = text;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        if (nextButton) nextButton();
        createButton();
    }

    public void createButton(){
        this.setText(text);
        this.setFont(font);
        this.setBounds(x, y, buttonWidth, buttonHeight);
        this.setFocusable(false);
    }
    public void nextButton(){
        this.buttonWidth = nextButtonWidth;
        this.buttonHeight = nextButtonHeight;
    }
}
