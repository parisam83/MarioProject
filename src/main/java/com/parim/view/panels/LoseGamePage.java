package com.parim.view.panels;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.LabelCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoseGamePage extends JPanel {
    public LoseGamePage(){
        LabelCreator sorryLabel = new LabelCreator(MainFrame.getGameHeight()/2 - 75, "Sorry :(", FontLoader.titleFont);
        sorryLabel.setForeground(new Color(199, 0,57)); //  195, 55, 49
        this.add(sorryLabel);

        LabelCreator loseLabel = new LabelCreator(MainFrame.getGameHeight()/2 + 10, "You lost the game.", FontLoader.titleFont);
        loseLabel.setForeground(new Color(30, 157, 171));
        this.add(loseLabel);

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
