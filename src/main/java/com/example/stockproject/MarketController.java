package com.example.stockproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MarketController {

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

    public void initialize() {
        Image image = new Image("file:OIP.jpeg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));

        Background background = new Background(backgroundImage);

        mainAnchorPane.setBackground(background);


        new Market("AAPL", 20.0, 12);
        new Market("Ahmed", 4321, 3224);
        new Market();

        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companySymbol"));
        pricePerStockColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerStock"));
        numStockColumn.setCellValueFactory(new PropertyValueFactory<>("numStocks"));

        tableView.setItems(stockList);
    }
}