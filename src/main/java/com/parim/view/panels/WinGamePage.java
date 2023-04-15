package com.parim.view.panels;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.LabelCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WinGamePage extends JPanel {
    public WinGamePage(){
        LabelCreator congratsLabel = new LabelCreator(MainFrame.getGameHeight()/2 - 75, "Congratulations!", FontLoader.titleFont);
        congratsLabel.setForeground(new Color(44, 173, 38));
        this.add(congratsLabel);

        LabelCreator wonLabel = new LabelCreator(MainFrame.getGameHeight()/2 + 10, "You won the game.", FontLoader.titleFont);
        wonLabel.setForeground(new Color(30, 157, 171));
        this.add(wonLabel);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    MainFrame.getInstance().setMenuPage();
                }
            }
        });
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }
}
