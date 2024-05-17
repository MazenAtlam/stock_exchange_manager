package com.example.stockproject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {
        protected static final Stage currStage = HelloApplication.stage;
        protected  Parent root;
        protected  Scene currScene;
        public void display(String sceneName){
                try {
                        root = FXMLLoader.load(getClass().getResource(sceneName));
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                currScene = new Scene(root);

                String[] title = sceneName.split("\\.", 2);
                currStage.setTitle(title[0]);
                // stage.getIcons().add(image);
                currStage.setScene(currScene);
                currStage.setResizable(false);
                currStage.show();
        }
//        public void setCurrStage(Stage stage){
//                currStage = stage;
//        }

}
