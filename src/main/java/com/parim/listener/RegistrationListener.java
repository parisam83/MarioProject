package com.parim.listener;

import com.parim.controller.UserController;
import com.parim.event.UserFormEvent;
import com.parim.model.User;
import com.parim.view.MainFrame;

public class RegistrationListener implements FormListener{
    @Override
    public void eventOccurred(UserFormEvent userFormEvent) {
        User user = new UserController(userFormEvent).registerUser();
        if (user == null)
            MainFrame.getInstance().unsuccessfulRegisterError();
        else{
            MainFrame.setUser(user);
            MainFrame.getInstance().setGamePage();
        }
    }
}