package com.example.stockproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    static User temp = Data.userFactory.GetUser(UserFactory.ADMIN);
    static User temp1 = Data.userFactory.GetUser(UserFactory.NORMAL);
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        temp.setUsername("mazenatef");
        temp.setPassword("11111111");
        temp1.setUsername("sherifelgendy");
        temp1.setPassword("11111111");
        Data.Admins.add(temp);
        Data.Users.add(temp1);
        launch();
    }
}