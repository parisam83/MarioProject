package com.parim.controller;

import com.parim.access.UserAccess;
import com.parim.event.UserFormEvent;
import com.parim.model.User;

public class UserController {
    private final UserFormEvent userFormEvent;
    private final UserAccess userAccess = new UserAccess();

    public UserController(UserFormEvent userFormEvent){
        this.userFormEvent = userFormEvent;
    }

    public User registerUser(){
        if (!userAccess.isDuplicate(userFormEvent.getUsername())){
            User user = new User(userAccess.numberOfUsers() + 1, userFormEvent.getUsername(), userFormEvent.getPassword());
            userAccess.add(user);
            return user;
        }
        return null;
    }

    public User loginUser(){
        return userAccess.findUser(userFormEvent.getUsername(), userFormEvent.getPassword());
    }
}
