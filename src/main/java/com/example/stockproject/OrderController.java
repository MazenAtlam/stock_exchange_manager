package com.example.stockproject;

import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PipedReader;

public class OrderController {


    private static Stage stage;


    public static ObservableList<Order> orderObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Order, String> orderTypeColumn;
    @FXML
    private TableColumn<Order, String> companySymbolColumn;

    @FXML
    private TableColumn<Order, Integer> numberOfOrderedStocksColumn;

    @FXML
    private TableColumn<Order, Integer> amountDepositedOrWithdrawnColumn;

    @FXML
    private TableColumn<Order, String> currentOrderStateColumn;

    @FXML
    private TableView<Order> tableViewOrders;

    @FXML
    private TableView<Order> tableViewOwnedAssets;

//    public void initialize() {
//
//        companySymbolColumn.setCellValueFactory("companySymbol");
//
//    }


    public void setPrimaryStage(Stage stage) {
        OrderController.stage = stage;
    }

    @FXML
    public void setPreviousScene() throws IOException {
        OrderController.stage.setScene(Account.getAccountScene());
        OrderController.stage.setTitle("Account");
    }



}
