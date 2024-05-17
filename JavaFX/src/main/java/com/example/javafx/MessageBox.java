package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.Label;

import java.io.IOException;

public class MessageBox {

    public static String title;
    public static String message;
    private static  Stage stage;

    @FXML
    Label label;
    @FXML
    Button btnOK;

    public void initialize() {
        try {
            label.setText(message);
            btnOK.setOnAction(e -> stage.close());
        } catch (Exception _) {}
    }

    public static void show(String title, String message) throws IOException {
                MessageBox.stage = new Stage();
                MessageBox.title = title;
                MessageBox.message = message;

                stage.setMinWidth(300);
                stage.setMinHeight(120);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle(title);
                stage.setResizable(false);

                FXMLLoader fxmlLoader = new FXMLLoader(MessageBox.class.getResource("messageBox.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                stage.setScene(scene);
                stage.showAndWait();
    }
}
