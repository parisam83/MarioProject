package com.parim.listener;

import com.parim.controller.ShopController;
import com.parim.event.ShopEvent;
import com.parim.view.MainFrame;

public class ShopListener {
    public String eventOccurred(ShopEvent shopEvent){
        ShopController shopController = new ShopController(shopEvent);
        String message = shopController.modifyCharacter();
        MainFrame.getInstance().addOptionPane(message);
        return message;
    }
}