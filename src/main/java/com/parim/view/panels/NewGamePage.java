package com.parim.view.panels;

import com.parim.model.Game;
import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.objects.swingObjects.LabelCreator;

public class NewGamePage extends SaveGamePage{
    public NewGamePage(User user) {
        super(user);
        for (int i = 0; i < buttons.size(); i++){
            final int index = i;
            buttons.get(i).addActionListener(e -> {
                MainFrame.getInstance().chooseDifficultyOfGame();
                user.addGame(index, new Game(user.getCurrentCharacter()));
                MainFrame.getInstance().setGamePage(user.GetLastAddedGame());
            });
        }
    }

    @Override
    public void setLabel() {
        label = new LabelCreator("Choose where to store this game...");
    }
}
