package com.parim.event;

import com.parim.model.Character;
import com.parim.model.User;

public class ShopEvent {
    private final User user;
    private final Character character;
    public ShopEvent(User user, Character character){
        this.user = user;
        this.character = character;
    }

    public User getUser() {
        return user;
    }
    public Character getCharacter() {
        return character;
    }
}
