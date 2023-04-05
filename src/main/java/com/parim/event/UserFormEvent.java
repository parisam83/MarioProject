package com.parim.event;

public class UserFormEvent {
    private final String username, password;

    public UserFormEvent(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
