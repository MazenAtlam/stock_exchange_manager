package com.example.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

    private String companySymbol;
    private String orderType;
    private int numberOfOrderedStocks;
    private double amountDepositedOrWithdrawn;
    private final StringProperty currentOrderState = new SimpleStringProperty();

}
