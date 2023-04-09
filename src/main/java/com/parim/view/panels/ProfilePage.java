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
        LabelCreator usernameLabel = new LabelCreator(buttonLabelGap, "Username: " + user.getUsername(), FontLoader.buttonFont);
        this.add(usernameLabel);

        // Character
        LabelCreator characterLabel = new LabelCreator(buttonLabelGap + buttonGap, "Character: " + user.getCurrentCharacter().toString(), FontLoader.buttonFont);
        this.add(characterLabel);

        // MaxScore
        LabelCreator maxScoreLabel = new LabelCreator(buttonLabelGap + buttonGap*2, "Max Score: " + String.valueOf(user.getMaxScore()), FontLoader.buttonFont);
        this.add(maxScoreLabel);

        ButtonCreator backButton = new ButtonCreator(MainFrame.getGameWidth()/2 - ButtonCreator.getNextButtonWidth()/2, 230 + 180*7/3, ButtonCreator.getNextButtonWidth(), ButtonCreator.getNextButtonHeight(), "<< Back <<", true);
        backButton.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(backButton);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public User getUser() {
        return user;
    }
}