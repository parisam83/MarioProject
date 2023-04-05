package com.parim.access;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parim.model.User;

import java.io.*;
import java.util.ArrayList;

public class UserAccess {
    private final String directory = "database";
    private final File databaseFile = new File(directory);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private ArrayList<User> users = new ArrayList<>();

    private void read(){
        for (int i = 1; i <= numberOfUsers(); i++) {
            FileReader reader;
            try {
                reader = new FileReader(directory + "/user" + String.valueOf(i) + ".json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            users.add(gson.fromJson(reader, User.class));
        }
    }
    public void add(User user){
        try {
            FileWriter writer = new FileWriter(directory + "/user" + String.valueOf(user.getId()) + ".json");
            gson.toJson(user, writer);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isDuplicate(String username){
        read();
        for (User user : users)
            if (user.getUsername().equals(username))
                return true;
        return false;
    }
    public User findUser(String username, String password){
        read();
        for (User user : users)
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        return null;
    }

    public int numberOfUsers(){
        if (databaseFile.list() == null)
            return 0;
        return databaseFile.list().length;
    }
}
