package com.parim.view.panels;

import com.parim.event.ShopEvent;
import com.parim.listener.ShopListener;
import com.parim.model.Character;
import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.ButtonCreator;
import com.parim.view.objects.swingObjects.LabelCreator;
import com.parim.view.objects.swingObjects.ShopButtonCreator;

import javax.swing.*;

public class ShopPage extends JPanel {
    private final User user;
    private LabelCreator coins;
    private ShopButtonCreator[] shopButtons = new ShopButtonCreator[5];
    public ShopPage(User user){
        this.user = user;

        LabelCreator label = new LabelCreator("Shop!");
        this.add(label);

        ButtonCreator backButton = new ButtonCreator(MainFrame.getGameWidth()/2 - ButtonCreator.getNextButtonWidth()/2, 290 + 180*7/3, ButtonCreator.getNextButtonWidth(), ButtonCreator.getNextButtonHeight(), "<< Back <<", true);
        backButton.addActionListener(e -> MainFrame.getInstance().setGamePage());
        this.add(backButton);

        coins = new LabelCreator(5, 10, "Coins: " + user.getCoins(), FontLoader.font.deriveFont(35f));
        this.add(coins);

        shopButtons[0] = new ShopButtonCreator(0, true, user.getCurrentCharacter());
        this.add(shopButtons[0]);

        int index = 1;
        for (Character character : Character.values())
            if (character != user.getCurrentCharacter()){
                shopButtons[index] = new ShopButtonCreator(index, user.getCharacters().contains(character), character);
                int finalIndex = index;
                shopButtons[index].addActionListener(e -> setButtons(finalIndex, new ShopListener().eventOccurred(new ShopEvent(user, shopButtons[finalIndex].getCharacter()))));
                this.add(shopButtons[index]);
                index++;
            }

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public void setButtons(int smallIndex, String message){
        coins.setText("Coins: " + user.getCoins());
        if (!message.contains("successfully")) return;
        System.out.println(shopButtons[0].getCharacter().name() + "   " + shopButtons[smallIndex].getCharacter().name());
        System.out.println(shopButtons[0].getActionListeners().length + "   " + shopButtons[smallIndex].getActionListeners().length);
        ShopButtonCreator.swapButtons(shopButtons[0], shopButtons[smallIndex]);
    }

    public User getUser() {
        return user;
    }
}
