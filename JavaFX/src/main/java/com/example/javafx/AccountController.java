package com.example.javafx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/**
 *
 */
public class AccountController {

    public static Account account;


    @FXML
    TextField priceTextField;


    @FXML
    Label errorMessage;

    @FXML
    Label errorMessage1;

    @FXML
    Label errorMessage2;

    @FXML
    Label errorMessage3;

    @FXML
    TextField stockAmountTextField;

    @FXML
    ChoiceBox<String> orderType;

    @FXML
    ChoiceBox<String> companySymbolChoiceBox;

    @FXML
    Label balanceLabel;
    private static int flag = 0;
    private static Stage stage;

    /**
     *
     */
    public void initialize() {
        if (flag == 0)
        {
        new Account(400);
        new Market("AAPL", 20.0, 3);
        new Market("Ahmed", 4321, 3224);
        flag++;
        }


        //For Original Scene
        try {
        balanceLabel.textProperty().bind(account.balanceProperty().asString("Balance: $%.2f"));
        } catch (Exception _) {}
        //For PlaceOrder Scene
        try {
            orderType.getItems().addAll("Buy", "Sell");
            companySymbolChoiceBox.getItems().addAll(Market.companySymbolList);
            errorMessage.setVisible(false); errorMessage1.setVisible(false); errorMessage2.setVisible(false); errorMessage3.setVisible(false);
            orderType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number index, Number newIndex) {
                    errorMessage.setVisible(false);
                    priceTextField.setDisable(newIndex.intValue() == 0);
                    priceTextField.clear();
                    errorMessage3.setVisible(false);
                }
            });
            companySymbolChoiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> errorMessage1.setVisible(false));
        } catch (Exception _) {}
    }



    /**
     * @throws IOException
     */
    @FXML
    public void setPreviousScene() throws IOException {
        AccountController.stage.setScene(Account.getAccountScene());
        AccountController.stage.setTitle("Account");
    }

    /**
     * @throws IOException
     */
    @FXML
    public void placeOrderScene() throws IOException {
        AccountController.stage.setScene(new Scene(new FXMLLoader(AccountController.class.getResource("PlaceOrder.fxml")).load()));
        AccountController.stage.setTitle("PlaceOrder");
    }

    /**
     * @param stage
     */
    public void setPrimaryStage(Stage stage) {
        AccountController.stage = stage;
    }

    /**
     * @return
     */
    public String getChosenType() {
        if (orderType.getValue() == null) {
            throw new IllegalArgumentException();
        }
        return orderType.getValue();
    }

    /**
     * @return
     */
    public String getChosenSymbol() {
        if (companySymbolChoiceBox.getValue() == null) {
            throw new IllegalArgumentException();
        }
        return companySymbolChoiceBox.getValue();
    }

    /**
     * @return
     */
    public double getPrice() {
        if (isPositiveDouble(priceTextField, errorMessage3))
            return Double.parseDouble(priceTextField.getText());
        return 0;
    }

    /**
     * @return
     */
    public int getStockAmount() {
        if (isPositiveInt(stockAmountTextField, errorMessage2))
            return Integer.parseInt(stockAmountTextField.getText());
        return (0);
    }

    /**
     * @param textField
     * @param errorMessage2
     * @return
     */
    public boolean isPositiveInt(TextField textField, Label errorMessage2) {
        if (!textField.getText().isBlank()) {
                    try {
                        NumberValidator.validateNumber(NumberValidator.validateInteger(Double.parseDouble(textField.getText())));
                        return (true);
                    } catch (NumberFormatException _) {
                        errorMessage2.setText("Invalid Amount");
                    } catch (NegativeNumberException _) {
                        errorMessage2.setText("Negative Number Not Allowed");

                    } catch (NotAnIntegerException _) {
                        errorMessage2.setText("Only Integer Allowed");
                    }
        }
        return (false);
    }

    /**
     * @param textField
     * @param errorMessage3
     * @return
     */
    public boolean isPositiveDouble(TextField textField, Label errorMessage3) {
        if (!textField.getText().isBlank()) {
            try {
                NumberValidator.validateNumber(Double.parseDouble(textField.getText()));
                return true;
            } catch (NumberFormatException _) {
                errorMessage3.setText("Invalid Amount");
            } catch (NegativeNumberException _) {
                errorMessage3.setText("Negative Number Not Allowed");
            }
        }
        return (false);
    }

    /**
     *
     */
    @FXML
    public boolean validatePrice() {
        if (!priceTextField.isDisabled()) {
        errorMessage3.setVisible(!isPositiveDouble(priceTextField, errorMessage3));
        return !isPositiveDouble(priceTextField, errorMessage3);
        }
        return (false);
    }

    /**
     *
     */
    @FXML
    public boolean validateStockAmount() {
        errorMessage2.setVisible(!isPositiveInt(stockAmountTextField, errorMessage2));
        return !isPositiveInt(stockAmountTextField, errorMessage2);
    }


    private void emptyFieldValidation() {
        try {
            getChosenType();
            errorMessage.setVisible(false);
        } catch (IllegalArgumentException _) {
            errorMessage.setText("Empty Field");
            errorMessage.setVisible(true);
        }
        try {
            getChosenSymbol();
            errorMessage1.setVisible(false);
        } catch (IllegalArgumentException _) {
            errorMessage1.setText("Empty Field");
            errorMessage1.setVisible(true);
        }
        errorMessage2.setText("Empty Field");
        errorMessage3.setText("Empty Field");
        errorMessage3.setVisible(validatePrice());
        errorMessage2.setVisible(validateStockAmount());
    }

    /**
     *
     */
    @FXML
    public void GeneralValidation() {
         emptyFieldValidation();
         try {
             if (getChosenType().contains("Buy")) {
             NumberValidator.validatePriceAvailability(calculateTotalPrice(), account, errorMessage3);
             NumberValidator.validateMarketStocksAvailability(getStockAmount(), getChosenSymbol(), errorMessage3);
             }
         } catch (IllegalArgumentException | IOException _) {}

    }


    @FXML
    public void addOrder() throws IOException {
        if (!(errorMessage1.isVisible() || errorMessage.isVisible() || errorMessage2.isVisible() || errorMessage3.isVisible())) {
            // Entries Is Correct And Valid, Return to previous scene and add the order

            executeBuyOrder();
            executeSellOrder();
            // To Update Market
            Market.getInstance(getChosenSymbol()).setNumStocks(Market.getInstance(getChosenSymbol()).getNumStocks() - getStockAmount());
            setPreviousScene();
        }
    }

    private double calculateTotalPrice() {
        return (Market.getInstance(getChosenSymbol()).getPricePerStock() * getStockAmount());
    }

    private void executeBuyOrder() {
        if (getChosenType().equals("Buy")) {
            account.setBalance(account.getBalance() - calculateTotalPrice());
            account.setNumberOfOrders((account.getNumberOfOrders()) + 1);
        }
    }

    private void executeSellOrder() {
        if (getChosenSymbol().equals("Sell")) {
            account.setBalance(account.getBalance() + calculateTotalPrice());
            account.setNumberOfOrders((account.getNumberOfOrders()) + 1);
        }
    }

}
