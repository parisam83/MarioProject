package com.parim.view.panels;

import com.parim.event.UserFormEvent;
import com.parim.view.MainFrame;
import com.parim.view.objects.swingObjects.ButtonCreator;
import com.parim.view.objects.swingObjects.LabelCreator;
import com.parim.view.objects.swingObjects.TextFieldCreator;

import javax.swing.*;

public abstract class AccountPage extends JPanel {
    private static final int textFieldLabelGap = 230, textFieldGap = 180;
    protected LabelCreator label;
    protected TextFieldCreator username, password;
    public AccountPage(){
        setLabel();
        this.add(label);

        username = new TextFieldCreator(textFieldLabelGap, "username");
        this.add(username);

        password = new TextFieldCreator(textFieldLabelGap + textFieldGap, "password");
        this.add(password);

        ButtonCreator nextButton = new ButtonCreator(MainFrame.getGameWidth()/2 + 300, textFieldLabelGap + textFieldGap*7/3, ButtonCreator.getNextButtonWidth(), ButtonCreator.getNextButtonHeight(), ">> Next >>", true);
        nextButton.addActionListener(e -> listener(new UserFormEvent(username.getText(), password.getText())));
        this.add(nextButton);

        ButtonCreator backButton = new ButtonCreator(MainFrame.getGameWidth()/2 - 300 - ButtonCreator.getNextButtonWidth(), textFieldLabelGap + textFieldGap*7/3, ButtonCreator.getNextButtonWidth(), ButtonCreator.getNextButtonHeight(), "<< Back <<", true);
        backButton.addActionListener(e -> MainFrame.getInstance().setFirstPage());
        this.add(backButton);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public boolean isDefaultValue(){
        return username.getText().equals("username") && password.getText().equals("password");
    }
    public abstract void setLabel();
    public abstract void listener(UserFormEvent userFormEvent);
}
