package com.example.stockproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Normal_User_Scene extends Controller implements Initializable {
    @FXML
    private TitledPane profileVeiw;
    @FXML
    private Label usernameField ,UserId;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label LabelField;
    Stage stage;
    Parent root;
    Scene scene;
//    FXMLLoader loader = new FXMLLoader();

    private String chosedOption;
//    private String username ;

    private final String[] Options = {"DisplayTransactionHistory", "ExportStockHistory" , "Be premium for 10$" };


    //     private Account account ;   //until Account class created
    private boolean premium;
    // private ArrayList<Order> transactions = new ArrayList<Order>(); until order class created
//    StockSubject stocksubject;



    @FXML
    public void AfterCancel(ActionEvent event) throws IOException {
//        ShowStage("hello-view.fxml",event);
        display("hello-view.fxml");
    }

    @FXML
    public void ShowName(){
        LabelField.setText(Data.Users.get(Data.getUserIndex()).GetUsername());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(Options);
        choiceBox.setOnAction(this::changeScene);
    }

    @FXML
    public  void changeScene(ActionEvent event){
        chosedOption = choiceBox.getValue();
        switch (chosedOption){
            case  "DisplayTransactionHistory":
                //                    ShowStage("ExportHistory.fxml",event);
                display("ExportHistory.fxml");
                break;
            case  "ExportStockHistory":
//                    ShowStage("ExportHistory.fxml",event);
                display("ExportHistory.fxml");
                break;
            case  "Be premium for 10$" :
                //                    ShowStage("ExportHistory.fxml",event);
                display("ExportHistory.fxml");
                break;
        }

    }



    @FXML
    public void changeToMarket(ActionEvent event) throws IOException{
//        ShowStage("Market.fxml",event);
        display("Market.fxml");
        Controller.currStage.show();
    }
    @FXML
    public void changeToAccount(ActionEvent event) throws IOException{
//        ShowStage("Market.fxml",event);
        display("Market.fxml");
    }

    @FXML
    public void changeName(ActionEvent event) throws IOException{
//        ShowStage("ChangeName.fxml",event);
        display("ChangeName.fxml");
    }
    @FXML
    public void changePassword(ActionEvent event) throws IOException{
//        ShowStage("ChangePassword.fxml",event);
            display("ChangePassword.fxml");
    }

    @FXML
    public void JoinSession(ActionEvent event) throws IOException{
//        ShowStage("SessionScene.fxml",event);
        display("SessionScene.fxml");
    }
}
