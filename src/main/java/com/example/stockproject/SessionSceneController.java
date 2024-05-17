package com.example.stockproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SessionSceneController extends Controller  {

    @FXML
    private TitledPane profileVeiw;
    @FXML
    private ListView <String> companyList;
    @FXML
    private Label usernameField ,UserId;


    public void initialize() {
        profileVeiw.setExpanded(false);
        setInformation();
    }

//    private void ShowStage(String name ,ActionEvent event  ) throws IOException {
//        root = (FXMLLoader.load(getClass().getResource(name)));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }


    public void setInformation(){
        usernameField.setText(Data.Users.get(Data.getUserIndex()).username);  ;
        UserId.setText(String.valueOf((Data.Users.get(Data.getUserIndex()).getId())));
    }



    @FXML
    public void changeName(ActionEvent event) throws IOException {
//        ShowStage("ChangeName.fxml", event);
        display("ChangeName.fxml");
    }



    @FXML
    public void changeToAccount(ActionEvent event) throws IOException {
//        ShowStage("Market.fxml",event);
        display("Market.fxml");
    }
    @FXML
    public void back(ActionEvent event) throws IOException{
//        ShowStage("NormalUserScene.fxml",event);
        display("NormalUserScene.fxml");
    }
    @FXML
    public void changePassword(ActionEvent event) throws IOException{
//        ShowStage("ChangePassword.fxml",event);
        display("ChangePassword.fxml");

    }



}
