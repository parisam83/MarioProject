package com.parim.view.panels;

import com.parim.model.Character;
import com.parim.model.Game;
import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.objects.swingObjects.ButtonCreator;
import com.parim.view.objects.swingObjects.LabelCreator;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class SaveGamePage extends JPanel {
    private static final int buttonLabelGap = 230, buttonGap = 180;
    protected LabelCreator label;
    protected ArrayList<Game> savedGames;
    protected ArrayList<ButtonCreator> buttons = new ArrayList<ButtonCreator>(3){{add(null); add(null); add(null);}};
    public SaveGamePage(User user){
        savedGames = user.getSavedGames();
        setLabel();
        this.add(label);

        for (int i = 0; i < savedGames.size(); i++) {
            final int index = i;
            ButtonCreator button = new ButtonCreator(buttonLabelGap + buttonGap * i, savedGames.get(i).getCurrentState(), false);
            buttons.set(i, button);
            this.add(button);
        }
        for (int i = savedGames.size(); i < 3; i++) {
            ButtonCreator button = new ButtonCreator(buttonLabelGap + buttonGap * i, "----", false);
            buttons.set(i, button);
            this.add(button);
        }

        this.addKeyListener(new AL());
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public abstract void setLabel();
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                MainFrame.getInstance().setMenuPage();
        }
    }
}
