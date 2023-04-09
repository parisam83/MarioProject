package com.parim.view.panels;

import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.objects.swingObjects.LabelCreator;

public class PreviousGamePage extends SaveGamePage{
    public PreviousGamePage(User user) {
        super(user);
        for (int i = 0; i < buttons.size(); i++){
            final int index = i;
            if (i < savedGames.size())
                buttons.get(i).addActionListener(e -> MainFrame.getInstance().setGamePage(savedGames.get(index)));
            else
                buttons.get(i).setEnabled(false);
        }
    }

    @Override
    public void setLabel() {
        label = new LabelCreator("Choose one of the games...");
    }
}
