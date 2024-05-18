package com.example.stockproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class Order {




    private String companySymbol = "-";
    private String orderType;
    private Integer numberOfOrderedStocks;
    private Double amountDepositedOrWithdrawn;
    private final StringProperty currentOrderState = new SimpleStringProperty("Pending");
    public static int flag;

    public Integer getNumberOfOrderedStocks() {
        return numberOfOrderedStocks;
    }

    public String getCompanySymbol() {
        return companySymbol;
    }
    public String getOrderType() {
        return orderType;
    }

    public Double getAmountDepositedOrWithdrawn() {
        return amountDepositedOrWithdrawn;
    }


    public String getCurrentOrderState() {
        return currentOrderState.get();
    }

    public StringProperty currentOrderStateProperty() {
        return currentOrderState;
    }



    public Order(double amountDepositedOrWithdrawn) {
        if (flag == 1) {
            this.orderType = "Withdraw";
        }
        else {
            this.orderType = "Deposit";
        }
        this.amountDepositedOrWithdrawn = amountDepositedOrWithdrawn;
    }

    //Should Be Executed if numberOfOrderedStocks > 0
    public Order(String companySymbol, int numberOfOrderedStocks, String orderType) {
        this.companySymbol = companySymbol;
        this.numberOfOrderedStocks = numberOfOrderedStocks;
        this.orderType = orderType;
    }

    public static Scene getOrderScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OrderController.class.getResource("Order.fxml"));
        return (new Scene(fxmlLoader.load()));
    }

}
