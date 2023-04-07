package com.parim.view.objects.swingObjects;

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
        if (nextButton) nextButton();
        this.x = MainFrame.getGameWidth()/2 - buttonWidth/2;
        this.y = y;
        this.buttonWidth = normalButtonWidth;
        this.buttonHeight = normalButtonHeight;
        if (nextButton) nextButton();
        this.text = text;
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
    public ButtonCreator(int x, int y, int buttonWidth, int buttonHeight, String text, boolean nextButton, ImageIcon image){
        this.x = x;
        this.y = y;
        this.text = text;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        if (nextButton) nextButton();
        createButton();
        this.setIcon(image);
    }

    public void createButton(){
        this.setText(text);
        this.setFont(font);
        this.setBounds(x, y, buttonWidth, buttonHeight);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }
    public void nextButton(){
        this.buttonWidth = nextButtonWidth;
        this.buttonHeight = nextButtonHeight;
    }

    public static int getNextButtonWidth() {
        return nextButtonWidth;
    }
    public static int getNextButtonHeight() {
        return nextButtonHeight;
    }
    public static int getNormalButtonWidth() {
        return normalButtonWidth;
    }
    public static int getNormalButtonHeight() {
        return normalButtonHeight;
    }
}
