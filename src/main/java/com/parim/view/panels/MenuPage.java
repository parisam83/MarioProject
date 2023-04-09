package com.parim.view.panels;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.ButtonCreator;
import com.parim.view.objects.swingObjects.LabelCreator;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuPage extends JPanel {
    private static final int buttonLabelGap = 180, buttonGap = 170;
    public MenuPage(){
        LabelCreator label = new LabelCreator("Supper Xayyati Game!");
        this.add(label);

        ButtonCreator newGameButton = new ButtonCreator(MainFrame.getGameWidth()/2 - 100 - ButtonCreator.getNormalButtonWidth(), buttonLabelGap, "Start new game", false);
        newGameButton.addActionListener(e -> MainFrame.getInstance().setNewGamePage());
        this.add(newGameButton);

        ButtonCreator prevGameButton = new ButtonCreator(MainFrame.getGameWidth()/2 - 100 - ButtonCreator.getNormalButtonWidth(), buttonLabelGap + (buttonGap), "Continue previous games", FontLoader.font.deriveFont(35f), false);
        prevGameButton.addActionListener(e -> MainFrame.getInstance().setPreviousGamePage());
        this.add(prevGameButton);

        ButtonCreator leaderBoardButton = new ButtonCreator(buttonLabelGap + (buttonGap)*2, "Leaderboard", false);
        leaderBoardButton.addActionListener(e -> MainFrame.getInstance().setLeaderBoardPage());
        this.add(leaderBoardButton);

        ButtonCreator shopButton = new ButtonCreator(MainFrame.getGameWidth()/2 + 100, buttonLabelGap, "Shop", false);
        shopButton.addActionListener(e -> MainFrame.getInstance().setShopPage());
        this.add(shopButton);

        ButtonCreator profileButton = new ButtonCreator(MainFrame.getGameWidth()/2 + 100, buttonLabelGap + (buttonGap), "Profile", false);
        profileButton.addActionListener(e -> MainFrame.getInstance().setProfilePage());
        this.add(profileButton);

        ButtonCreator backButton = new ButtonCreator(buttonLabelGap + (buttonGap)*3-10, "<< Back <<", true);
        backButton.addActionListener(e -> MainFrame.getInstance().setFirstPage());
        this.add(backButton);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }
}