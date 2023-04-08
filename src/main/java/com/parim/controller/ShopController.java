package com.parim.controller;

import com.parim.access.UserAccess;
import com.parim.event.ShopEvent;
import com.parim.model.Character;
import com.parim.model.User;

public class ShopController {
    private final ShopEvent shopEvent;
    private final User user;
    private final Character character;
    private final UserAccess userAccess = new UserAccess();
    public ShopController(ShopEvent shopEvent){
        this.shopEvent = shopEvent;
        this.user = shopEvent.getUser();
        this.character = shopEvent.getCharacter();
    }

    public String modifyCharacter(){
        if (user.getCurrentCharacter() == character)
            return "This character is your current character";
        else if (user.getCharacters().contains(character)){
            user.setCurrentCharacter(character);
            userAccess.add(user);
            return "Character changed successfully.";
        }
        else if (user.getCoins() >= character.getPrice()){
            user.setCoins(user.getCoins() - character.getPrice());
            user.setCurrentCharacter(character);
            user.addCharacter(character);
            userAccess.add(user);
            return "You bought " + character.name() + " character successfully!";
        }
        else
            return "You don't have enough money to buy this character :(";
    }
}
