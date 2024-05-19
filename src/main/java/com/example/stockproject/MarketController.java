package com.example.stockproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MarketController extends Controller  {

    @FXML
    public AnchorPane mainAnchorPane;

    @FXML
    private TableView<Market> tableView;
    public final static ObservableList<Market> stockList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Market, String> companyNameColumn;
    @FXML
    private TableColumn<Market, Double> pricePerStockColumn;
    @FXML
    private TableColumn<Market, Integer> numStockColumn;


    /**
     *
     */
    public void initialize() {

        currUser = Data.Users.get(Data.TempID);
        new Market("AAPL", 20.0, 12);
        new Market("Ahmed", 4321, 3224);

        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companySymbol"));
        pricePerStockColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerStock"));
        numStockColumn.setCellValueFactory(new PropertyValueFactory<>("numStocks"));

        tableView.setItems(stockList);
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
//        ShowStage("NormalUserScene.fxml",event);
        display(currUser,"NormalUserScene.fxml");
    }


}