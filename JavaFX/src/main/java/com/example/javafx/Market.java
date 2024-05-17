package com.example.javafx;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.random.RandomGenerator;

/**
 *
 */
public class Market {

    private final StringProperty companySymbol = new SimpleStringProperty();
    private final DoubleProperty pricePerStock =  new SimpleDoubleProperty();
    private final IntegerProperty numStocks = new SimpleIntegerProperty();
    public final static ObservableList<String> companySymbolList = FXCollections.observableArrayList();

        /*************************/
    private final String[] popularSymbols = new String[]{"AAPL", "GOOGL", "MSFT", "AMZN", "FB", "TESLA", "NVDA", "NFLX",
            "BABA", "V", "JNJ", "JPM", "WMT", "PG"};

    public final static Map<String, double[]> stockData = new HashMap<>();

    private final double[] initialValues = new double[]{0.0, 0.0, 0.0, 0.0};

    private   void loadSymbols() {
        for (String symbol : popularSymbols) {
            stockData.put(symbol, initialValues);
        }
    }
        /***********************/


    public void setNumStocks(int numStocks) {
        this.numStocks.set(numStocks);
    }

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
        loadSymbols();
        for (String companyName : companySymbolList) {
            if (companyName.equals(companySymbol)) {
                return;
            }
        }
        this.companySymbol.setValue(companySymbol);
        this.numStocks.setValue(numStocks);
        this.pricePerStock.setValue(pricePerStock);
        MarketController.stockList.add(this);
        companySymbolList.add(companySymbol);
    }

    /**
     * @param companyName
     */
    public static void removeCompany(String companyName) {
        MarketController.stockList.removeIf(marketObject -> marketObject.getCompanySymbol().equals(companyName));
        companySymbolList.remove(companyName);
        System.out.println(companyName);
    }

    /**
     * @return
     * @throws IOException
     */
    public static Scene getMarketScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Market.class.getResource("Market.fxml"));
        return (new Scene(fxmlLoader.load()));
    }

    /**
     * @param marketSymbol
     * @return
     */
    public static Market getInstance(String marketSymbol) {
        for (Market market : MarketController.stockList) {
            if (market.getCompanySymbol().equals(marketSymbol)) {
                return (market);
            }
        }
        return (null);
    }


    /**
     *
     */
    private static void updateMarket() {
        for (Market market : MarketController.stockList) {
            if (market.getNumStocks() == 0) {
                removeCompany(market.getCompanySymbol());
            }
        }
    }

}
