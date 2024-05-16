package com.example.javafx;

import javafx.scene.control.Label;

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

    public static void validatePriceAvailability(double enteredPrice, Account account, Label errorMessage) {
        if (enteredPrice > account.getBalance()) {
            errorMessage.setText("Account Balance Insufficient");
            errorMessage.setVisible(true);
        }
    }
}