package com.example.javafx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

    private static Stage stage;

    public void initialize() {
        new Market("AAPL", 20.0, 12);
        new Market("Ahmed", 4321, 3224);
        new Account(20.00);
        //For Original Scene
        try {
        balanceLabel.textProperty().bind(account.balanceProperty().asString("Balance: $%.2f"));
        } catch (Exception _) {}
        //For PlaceOrder Scene
        try {
            orderType.getItems().addAll("Buy", "Sell");
            companySymbolChoiceBox.getItems().addAll(Market.companySymbolList);
            errorMessage.setVisible(false); errorMessage1.setVisible(false); errorMessage2.setVisible(false); errorMessage3.setVisible(false);
        } catch (Exception _) {}
    }

    public void buy() {

    }

    @FXML
    public void setPreviousScene() throws IOException {
        AccountController.stage.setScene(Account.getAccountScene());
        AccountController.stage.setTitle("Account");
        System.out.println(getChosenSymbol());
    }

    @FXML
    public void placeOrder() throws IOException {
        AccountController.stage.setScene(new Scene(new FXMLLoader(AccountController.class.getResource("PlaceOrder.fxml")).load()));
        AccountController.stage.setTitle("PlaceOrder");
    }

    public void setPrimaryStage(Stage stage) {
        AccountController.stage = stage;
    }

    public String getChosenType() {
        return orderType.getValue();
    }

    public String getChosenSymbol() {
        return companySymbolChoiceBox.getValue();
    }

    public String getPrice() {
        return priceTextField.getText();
    }

    public String getStockAmount() {
        return stockAmountTextField.getText();
    }

    @FXML
    public void checkForEmptyField() {
        errorMessage1.setVisible(getChosenSymbol() == null);
        errorMessage3.setVisible(getPrice().isBlank());
        errorMessage.setVisible(getChosenType() == null);
        errorMessage2.setVisible(getStockAmount().isBlank());
    }
}
