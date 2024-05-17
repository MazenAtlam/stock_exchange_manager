package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Market");
        stage.setScene(Market.getMarketScene());
        stage.setResizable(false);
        stage.show();

        AccountController accountController =  new AccountController();
        accountController.setPrimaryStage(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}