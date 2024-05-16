package com.example.stock_manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    static HelloController controller ;
    Stock mystock = new Stock();
    @Override
    public void start(Stage stage) throws IOException {
        draw_chart(mystock,stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void draw_chart(Stock stock,Stage stage) throws IOException {
        controller=new HelloController(stock);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 600, 600, Color.LIGHTBLUE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}