package com.example.javafx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

public class Account {

    public static FXMLLoader fxmlLoader;
    private final DoubleProperty balance;

    public void setBalance(double balance) {
        this.balance.set(balance);
    }
    public double getBalance() {
        return balance.get();
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public Account() {
        this.balance = new SimpleDoubleProperty(0.00);
        AccountController.account = this;
    }

    public Account(double balance) {
        this.balance = new SimpleDoubleProperty(balance);
        AccountController.account = this;
    }

    public static Scene getAccountScene() throws IOException {
        Account.fxmlLoader = new FXMLLoader(AccountController.class.getResource("Account.fxml"));
        return (new Scene(fxmlLoader.load()));
    }


}
