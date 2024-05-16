package com.example.javafx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Account {

    private final DoubleProperty balance;
    private final IntegerProperty numberOfOrders = new SimpleIntegerProperty(0);
    private static int id = 0;
    private final int accountId;
    private static final List<Account> accountList = new ArrayList<>();


    public int getAccountId() {
        return this.accountId;
    }

    public int getNumberOfOrders() {
        return numberOfOrders.get();
    }

    public IntegerProperty numberOfOrdersProperty() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders.set(numberOfOrders);
    }



    /**
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance.set(balance);
    }

    /**
     * @return
     */
    public double getBalance() {
        return balance.get();
    }

    /**
     * @return
     */
    public DoubleProperty balanceProperty() {
        return balance;
    }

    public Account() {
        this.accountId = Account.id++;
        this.balance = new SimpleDoubleProperty(0.00);
        Account.accountList.add(this);
       AccountController.account = this;
    }

    public Account(double balance) {
        this.accountId = Account.id++;
        this.balance = new SimpleDoubleProperty(balance);
        Account.accountList.add(this);
        AccountController.account = this;
    }

    /**
     * @return
     * @throws IOException
     */
    public static Scene getAccountScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AccountController.class.getResource("Account.fxml"));
        return (new Scene(fxmlLoader.load()));
    }


    /**
     * @param userIndex
     */
    public static void setUserAccount(int userIndex) {
        if (Account.id < userIndex) {
            new Account();
        } else {
            AccountController.account = Account.accountList.get(userIndex - 1);
        }
    }

}
