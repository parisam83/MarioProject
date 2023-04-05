package com.parim.view.panels;

import com.parim.event.UserFormEvent;
import com.parim.listener.RegistrationListener;
import com.parim.view.loaders.FontLoader;
import com.parim.view.objects.swingObjects.LabelCreator;

public class RegisterPage extends AccountPage{
    @Override
    public void setLabel() {
        label = new LabelCreator("Register a new account", FontLoader.titleFont);
        this.add(label);
    }

    @Override
    public void listener(UserFormEvent userFormEvent) {
        new RegistrationListener().eventOccurred(userFormEvent);
    }
}