package com.example.javafx;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 *
 */
public class NumberValidator {

    private static final double EPSILON = 0.00001;
    /**
     * @param number
     * @throws NegativeNumberException
     */
    public static void validateNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException();
        }
    }

    /**
     * @param number
     * @throws NegativeNumberException
     */
    public static void validateNumber(double number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException();
        }
    }

    /**
     * @param number
     * @return
     * @throws NotAnIntegerException
     */
    public static double validateInteger(double number) throws NotAnIntegerException {
        if (number != (int) number) {
            throw new NotAnIntegerException();
        }
        return number;
    }

    public static void validatePriceAvailability(double totalPrice, Account account, Label errorMessage) throws IOException {
        if (totalPrice > account.getBalance()) {
            MessageBox.show("Warning", "Insufficient Account Balance");
            errorMessage.setText("");
            errorMessage.setVisible(true);
        }
    }

    public static void validateMarketStocksAvailability(int requestedStockAmount, String companySymbol, Label errorMessage) throws IOException {
        if (requestedStockAmount > Market.getInstance(companySymbol).getNumStocks()) {
                MessageBox.show("Warning", "Specified Stock Amount Not Available");
                errorMessage.setText("");
                errorMessage.setVisible(true);
        }
    }
}