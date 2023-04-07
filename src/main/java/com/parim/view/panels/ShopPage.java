package com.parim.view.panels;

import com.parim.model.Character;
import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.objects.swingObjects.ButtonCreator;
import com.parim.view.objects.swingObjects.LabelCreator;

import javax.swing.*;

public class ShopPage extends JPanel {
    private static final int bigImageSize = 500, smallImageSize = 250;
    private final User user;
    public ShopPage(User user){
        this.user = user;

        LabelCreator label = new LabelCreator("Shop!");
        this.add(label);

        ButtonCreator currentCharacterButton = new ButtonCreator(MainFrame.getGameWidth()/2 - bigImageSize - 100, MainFrame.getGameHeight()/2 - bigImageSize/2, bigImageSize, bigImageSize, String.valueOf(user.getCurrentCharacter().getPrice()) + " coins :: bought", false, user.getCurrentCharacter().getPicture().getBig());
        this.add(currentCharacterButton);

        int index = 0;
        for (Character character : Character.values())
            if (character != user.getCurrentCharacter()){
                String text = " :: bought";
                if (!user.getCharacters().contains(character)) text = "";

                int x = MainFrame.getGameWidth()/2 + 100, y = MainFrame.getGameHeight()/2 - smallImageSize;
                if (index > 1) x += smallImageSize;
                if (index%2 == 0) y += smallImageSize;
                index++;
                ButtonCreator characterButton = new ButtonCreator(x, y, smallImageSize, smallImageSize, String.valueOf(character.getPrice()) + " coins" + text, false, character.getPicture().getSmall());
                this.add(characterButton);
            }

        ButtonCreator backButton = new ButtonCreator(MainFrame.getGameWidth()/2 - ButtonCreator.getNextButtonWidth()/2, 290 + 180*7/3, ButtonCreator.getNextButtonWidth(), ButtonCreator.getNextButtonHeight(), "<< Back <<", true);
        backButton.addActionListener(e -> MainFrame.getInstance().setGamePage());
        this.add(backButton);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public User getUser() {
        return user;
    }
}
