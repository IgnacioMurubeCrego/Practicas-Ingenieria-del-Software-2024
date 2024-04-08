package com.example.demo;

import javafx.beans.property.StringProperty ;
import javafx.beans.property.SimpleStringProperty ;

public class User {

    private final StringProperty userName = new SimpleStringProperty(this, "userName");
    private final StringProperty password = new SimpleStringProperty(this, "password");

    public StringProperty userNameProperty() {
        return userName ;
    }

    public final String getUserName() {
        return userNameProperty().get();
    }

    public final void setUserName(String userName) {
        userNameProperty().set(userName);
    }

    public StringProperty passwordProperty() {
        return password ;
    }

    public final String getPassword() {
        return passwordProperty().get();
    }
    public final void setPassword(String password) {
        passwordProperty().set(password);
    }

    public User(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

}
