package com.example.stockproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
//    @FXML
//    private ChoiceBox<String> choiceBox;
    @FXML
    private Label LabelField;


//    FXMLLoader loader = new FXMLLoader();

//    private String chosedOption;
//    private String username ;

//    private final String[] Options = {"DisplayTransactionHistory", "ExportStockHistory" , "Be premium for 10$" };


    //     private Account account ;   //until Account class created
    @FXML
    private Button bePremium;
    private boolean premium;
    // private ArrayList<Order> transactions = new ArrayList<Order>(); until order class created
//    StockSubject stocksubject;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currUser = Data.Users.get(Data.TempID);
        LabelField.setVisible(false);
    }


    @FXML
    public void AfterCancel(ActionEvent event) throws IOException {
//        ShowStage("hello-view.fxml",event);
        display("hello-view.fxml");

    }

//    @FXML
//    public void ShowName(){
//        LabelField.setText(Data.Users.get(Data.getUserIndex()).GetUsername());
//    }



//    @FXML
//    public  void changeScene(ActionEvent event){
//        chosedOption = choiceBox.getValue();
//        switch (chosedOption){
//            case  "DisplayTransactionHistory":
//                //                    ShowStage("ExportHistory.fxml",event);
//                display("ExportHistory.fxml");
//                break;
//            case  "ExportStockHistory":
////                    ShowStage("ExportHistory.fxml",event);
//                display("ExportHistory.fxml");
//                break;
//            case  "Be premium for 10$" :
//                //                    ShowStage("ExportHistory.fxml",event);
//                display("ExportHistory.fxml");
//                break;
//        }
//
//

    @FXML
     public void bePremium() {
        if (premium){
            premium = false;
            LabelField.setVisible(false);
            bePremium.setText("be premium 10$");
        }
        else {
            premium = true;
            LabelField.setVisible(true);
            bePremium.setText("unsubscribe");
        }
    }

    @FXML
    public void changeToMarket(ActionEvent event) throws IOException{
//        ShowStage("Market.fxml",event);
//        display("Market.fxml");
        Controller.currStage.setScene(Market.getMarketScene());

    }
    @FXML
    public void changeToAccount(ActionEvent event) throws IOException{
//        ShowStage("Market.fxml",event);
//        display("Market.fxml");
        Controller.currStage.setScene((Account.getAccountScene()));
    }

    @FXML
    public void changeName(ActionEvent event) throws IOException{
//        ShowStage("ChangeName.fxml",event);
        display(currUser,"ChangeName.fxml");
    }
    @FXML
    public void changePassword(ActionEvent event) throws IOException{
//        ShowStage("ChangePassword.fxml",event);
        display(currUser,"ChangePassword.fxml");
    }

    @FXML
    public void JoinSession(ActionEvent event) throws IOException{
//        ShowStage("SessionScene.fxml",event);
        display(currUser,"SessionScene.fxml");
    }
}