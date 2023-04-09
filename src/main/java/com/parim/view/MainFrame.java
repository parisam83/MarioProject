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
    private ProfilePage profilePage;
    private ShopPage shopPage;
    private LeaderBoardPage leaderBoardPage;
    private static final int gameWidth = 1500, gameHeight = 832;
    private static final Dimension screenSize = new Dimension(gameWidth, gameHeight);

    public MainFrame(){
        instance = this;
        this.setTitle("Super Xayyati Game!");
        this.setSize(screenSize);
        //this.setPreferredSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        setPage(firstPage);
    }

    public void setLoginPage() {
        loginPage = new LoginPage();
        setPage(loginPage);
    }
    public void setRegisterPage() {
        registerPage = new RegisterPage();
        setPage(registerPage);
    }
    public void setMenuPage(){
        menuPage = new MenuPage();
        setPage(menuPage);
    }
    public void setProfilePage(){
        profilePage = new ProfilePage(user);
        setPage(profilePage);
    }

    public void setShopPage(){
        if (shopPage == null || shopPage.getUser() != user)
            shopPage = new ShopPage(user);
        setPage(shopPage);
    }

    public void setLeaderBoardPage(){
        leaderBoardPage = new LeaderBoardPage();
        setPage(leaderBoardPage);
    }

    private void setPage(JPanel panel){
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        panel.requestFocus();
        panel.setVisible(true);
    }

    public void addOptionPane(String message){
        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
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