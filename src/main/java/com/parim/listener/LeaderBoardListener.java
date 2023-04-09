package com.parim.listener;

import com.parim.controller.UserController;
import com.parim.model.User;

import java.util.ArrayList;

public class LeaderBoardListener {
    public static Object[][] getAllUsers(){
        ArrayList<User> users = UserController.getAllUsersSorted();
        Object[][] finalUsers = new Object[users.size()][4];

        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (!(i > 0 && users.get(i).getMaxScore() == users.get(i - 1).getMaxScore())) index++;
            finalUsers[i] = new Object[]{index, users.get(i).getUsername(), users.get(i).getMaxScore()};
        }
        return finalUsers;
    }
}