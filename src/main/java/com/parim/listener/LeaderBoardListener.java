package com.parim.listener;

import com.parim.controller.UserController;
import com.parim.model.User;

import java.util.ArrayList;

public class LeaderBoardListener {
    public static Object[][] getAllUsers(){
        ArrayList<User> users = UserController.getAllUsersSorted();
        Object[][] finalUsers = new Object[users.size()][4];
        for (int i = 0; i < users.size(); i++)
            finalUsers[i] = new Object[]{i+1, users.get(i).getUsername(), users.get(i).getMaxScore()};
        return finalUsers;
    }
}
