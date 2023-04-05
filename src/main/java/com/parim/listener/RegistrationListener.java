package com.parim.listener;

import com.parim.controller.UserController;
import com.parim.event.UserFormEvent;

public class RegistrationListener implements FormListener{
    @Override
    public void eventOccurred(UserFormEvent userFormEvent) {
        UserController userController = new UserController(userFormEvent);
    }
}