package com.parim.view;

import com.parim.model.User;
import com.parim.view.panels.FirstPage;
import com.parim.view.panels.GamePage;
import com.parim.view.panels.LoginPage;
import com.parim.view.panels.RegisterPage;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private static User user;
    private FirstPage firstPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private GamePage gamePage;
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
        gamePage = new GamePage();
        this.setContentPane(gamePage);
        this.pack();
    }

    public void unsuccessfulLogin(){
        // TODO
    }

    public void unsuccessfulRegister(){
        // TODO
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