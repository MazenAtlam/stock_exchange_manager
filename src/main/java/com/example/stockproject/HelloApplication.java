package com.example.stockproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    static User temp = Data.userFactory.GetUser(UserFactory.ADMIN);
//    static User temp1 = Data.userFactory.GetUser(UserFactory.NORMAL);
    public static Stage stage;
//    static HelloController controller ;
    Stock mystock = new Stock();
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        Scene scene = new Scene(root, 600, 400);
//        stage.setScene(scene);
//        stage.show();

        HelloApplication.stage = stage;
        ChangeSceneController controller1 = new ChangeSceneController();
        controller1.display("hello-view.fxml");

//        draw_chart(mystock,stage); sherifelgendy
    }

    public static void main(String[] args)
    {
        try{
            Data.initStockData();
        } catch (Exception e){
            System.out.println("Error initing stocks data");
            System.out.println(e);
        }
        temp.setUsername("mazenatef");
        temp.setPassword("mazenatef");
        Data.Admins.put(1,temp);

//        temp1.setUsername("sherifelgendy");
//        temp1.setPassword("sherifelgendy");
       launch(args);
    }

//    public static void draw_chart(Stock stock,Stage stage) throws IOException {
//         controller = new HelloController(stock);
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("D:\\SBME\\oop\\stock\\stock_exchange_manager\\UI\\hello-view.fxml"));
//        fxmlLoader.setController(controller);
//        Scene scene = new Scene(fxmlLoader.load(), 600, 600, Color.LIGHTBLUE);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
}