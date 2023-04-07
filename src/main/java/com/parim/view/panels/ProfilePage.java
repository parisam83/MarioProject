package com.parim.view.panels;

import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.ButtonCreator;
import com.parim.view.objects.swingObjects.LabelCreator;

import javax.swing.*;

public class ProfilePage extends JPanel {
    private final User user;
    private static final int buttonLabelGap = 200, buttonGap = 80;
    public ProfilePage(User user){
        this.user = user;

        LabelCreator label = new LabelCreator("Profile page!");
        this.add(label);

        // Username
        LabelCreator usernameLabel = new LabelCreator(MainFrame.getGameWidth()/2 - 200, buttonLabelGap, "Username: ", FontLoader.buttonFont);
        LabelCreator usernameData = new LabelCreator(MainFrame.getGameWidth()/2 - 110, buttonLabelGap, user.getUsername(), FontLoader.buttonFont);
        this.add(usernameLabel);
        this.add(usernameData);

        // Character
        LabelCreator characterLabel = new LabelCreator(MainFrame.getGameWidth()/2 - 200, buttonLabelGap + buttonGap, "Character: ", FontLoader.buttonFont);
        LabelCreator characterData = new LabelCreator(MainFrame.getGameWidth()/2 - 85, buttonLabelGap + buttonGap, user.getCurrentCharacter().toString(), FontLoader.buttonFont);
        this.add(characterLabel);
        this.add(characterData);

        // MaxScore
        LabelCreator maxScoreLabel = new LabelCreator(MainFrame.getGameWidth()/2 - 200, buttonLabelGap + buttonGap*2, "Max Score: ", FontLoader.buttonFont);
        LabelCreator maxScoreData = new LabelCreator(MainFrame.getGameWidth()/2 - 100, buttonLabelGap + buttonGap*2, String.valueOf(user.getMaxScore()), FontLoader.buttonFont);
        this.add(maxScoreLabel);
        this.add(maxScoreData);

        ButtonCreator backButton = new ButtonCreator(MainFrame.getGameWidth()/2 - ButtonCreator.getNextButtonWidth()/2, 230 + 180*7/3, ButtonCreator.getNextButtonWidth(), ButtonCreator.getNextButtonHeight(), "<< Back <<", true);
        backButton.addActionListener(e -> MainFrame.getInstance().setGamePage());
        this.add(backButton);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public User getUser() {
        return user;
    }
}