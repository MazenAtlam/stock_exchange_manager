package org.example.demo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.nio.channels.Pipe;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.TimeZone;

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

