package com.parim.view;

import com.parim.model.User;
import com.parim.view.panels.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private static User user;
    private FirstPage firstPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private MenuPage menuPage;
    private ProfilePage profilePage = new ProfilePage(user);
    private static final int gameWidth = 1500, gameHeight = 832;
    private static final Dimension screenSize = new Dimension(gameWidth, gameHeight);

    public MainFrame(){
        instance = this;
        this.setTitle("Super Xayyati Game!");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFirstPage();
    }

    public static MainFrame getInstance() {
        return instance;
    }

    public static void setUser(User user) {
        MainFrame.user = user;
    }

    public void setFirstPage(){
        if (firstPage == null) firstPage = new FirstPage();
        this.setContentPane(firstPage);
        this.pack();
    }

    public void setLoginPage() {
        loginPage = new LoginPage();
        this.setContentPane(loginPage);
        this.pack();
    }
    public void setRegisterPage() {
        registerPage = new RegisterPage();
        this.setContentPane(registerPage);
        this.pack();
    }
    public void setGamePage(){
        menuPage = new MenuPage();
        this.setContentPane(menuPage);
        this.pack();
    }
    public void setProfilePage(){
        if (profilePage.getUser() != user)
            profilePage = new ProfilePage(user);
        this.setContentPane(profilePage);
        this.pack();
    }

    public void emptyValueInputError(){
        JOptionPane.showMessageDialog(this, "You cannot set your username or password empty!", "EmptyValueInputError", JOptionPane.ERROR_MESSAGE);
    }
    public void defaultValueInputError(){
        JOptionPane.showMessageDialog(this, "You cannot set your username and password as their default value!", "DefaultValueInputError", JOptionPane.ERROR_MESSAGE);
    }
    public void unsuccessfulLoginError(){
        JOptionPane.showMessageDialog(this, "Username or password is not correct!", "UnsuccessfulLoginError", JOptionPane.ERROR_MESSAGE);
    }

    public void unsuccessfulRegisterError(){
        JOptionPane.showMessageDialog(this, "This username is taken. Please try another username.", "UnsuccessfulRegisterError", JOptionPane.ERROR_MESSAGE);
    }

    public static int getGameWidth() {
        return gameWidth;
    }
    public static int getGameHeight() {
        return gameHeight;
    }
    public static Dimension getScreenSize() {
        return screenSize;
    }
}