package com.example.stockproject;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Market {
    private final StringProperty companySymbol;
    private final DoubleProperty pricePerStock;
    private final IntegerProperty numStocks;

    public final static ObservableList<String> companySymbolList = FXCollections.observableArrayList();

    public int getNumStocks() {
        return numStocks.get();
    }

    public double getPricePerStock() {
        return pricePerStock.get();
    }

    public String getCompanySymbol() {
        return companySymbol.get();
    }

    public IntegerProperty numStocksProperty() {
        return numStocks;
    }


    public StringProperty companySymbolProperty() {
        return companySymbol;
    }

    public DoubleProperty pricePerStockProperty() {
        return pricePerStock;
    }

    //Properties Corresponding to Columns in TableView

    public Market() {
        companySymbol = new SimpleStringProperty("XXXXXXX");
        pricePerStock = new SimpleDoubleProperty(0.00);
        numStocks = new SimpleIntegerProperty(0);
        MarketController.stockList.add(this);
    }


    public Market(String companySymbol, double pricePerStock, int numStocks) {
        this.companySymbol = new SimpleStringProperty(companySymbol);
        this.pricePerStock = new SimpleDoubleProperty(pricePerStock);
        this.numStocks = new SimpleIntegerProperty(numStocks);
        MarketController.stockList.add(this);
        companySymbolList.add(companySymbol);
    }

    public static void removeCompany(String companyName) {
        MarketController.stockList.removeIf(marketObject -> marketObject.getCompanySymbol().equals(companyName));
        companySymbolList.remove(companyName);
    }


}
