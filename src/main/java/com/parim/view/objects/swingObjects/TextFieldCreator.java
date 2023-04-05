package com.parim.view.objects.swingObjects;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldCreator extends JTextField {
    private int textFieldWidth = 350, textFieldHeight = 120;
    private final int x, y;
    private final String text;
    private final TextFieldCreator instance = this;

    public TextFieldCreator(int y, String text){
        this.x = MainFrame.getGameWidth()/2 - textFieldWidth/2;
        this.y = y;
        this.text = text;
        createTextField();
    }
    public TextFieldCreator(int x, int y, String text){
        this.x = x;
        this.y = y;
        this.text = text;
        createTextField();
    }
    public TextFieldCreator(int x, int y, int textFieldWidth, int textFieldHeight, String text){
        this.x = x;
        this.y = y;
        this.text = text;
        this.textFieldWidth = textFieldWidth;
        this.textFieldHeight = textFieldHeight;
        createTextField();
    }
    public void createTextField(){
        this.setText(text);
        this.setFont(FontLoader.buttonFont);
        this.setBounds(x, y, textFieldWidth, textFieldHeight);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                instance.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {}
        });
    }
}
