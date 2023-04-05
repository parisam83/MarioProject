package com.parim.view.panels;

import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.LabelCreator;

public class LoginPage extends AccountPage{
    @Override
    public void setLabel() {
        label = new LabelCreator("Login to your account", FontLoader.titleFont);
        this.add(label);
    }

    @Override
    public void validInput() {
        // TODO
    }
}
