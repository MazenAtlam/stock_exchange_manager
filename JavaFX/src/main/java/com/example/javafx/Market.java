package com.example.javafx;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Market {

    private final StringProperty companySymbol;
    private final DoubleProperty pricePerStock;
    private final IntegerProperty numStocks;

    public final static ObservableList<String> companySymbolList = FXCollections.observableArrayList();

    /**
     * @return
     */
    public int getNumStocks() {
        return numStocks.get();
    }

    /**
     * @return
     */
    public double getPricePerStock() {
        return pricePerStock.get();
    }

    /**
     * @return
     */
    public String getCompanySymbol() {
        return companySymbol.get();
    }

    /**
     * @return
     */
    public IntegerProperty numStocksProperty() {
        return numStocks;
    }


    /**
     * @return
     */
    public StringProperty companySymbolProperty() {
        return companySymbol;
    }

    /**
     * @return
     */
    public DoubleProperty pricePerStockProperty() {
        return pricePerStock;
    }

    //Properties Corresponding to Columns in TableView

    /**
     * @param companySymbol
     * @param pricePerStock
     * @param numStocks
     */
    public Market(String companySymbol, double pricePerStock, int numStocks) {
        this.companySymbol = new SimpleStringProperty(companySymbol);
        this.pricePerStock = new SimpleDoubleProperty(pricePerStock);
        this.numStocks = new SimpleIntegerProperty(numStocks);
        MarketController.stockList.add(this);
        companySymbolList.add(companySymbol);
    }

    /**
     * @param companyName
     */
    public static void removeCompany(String companyName) {
        MarketController.stockList.removeIf(marketObject -> marketObject.getCompanySymbol().equals(companyName));
        companySymbolList.remove(companyName);
    }

    /**
     * @return
     * @throws IOException
     */
    public static Scene getMarketScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Market.class.getResource("Market.fxml"));
        return (new Scene(fxmlLoader.load()));
    }
}
