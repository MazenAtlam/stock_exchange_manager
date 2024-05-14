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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Normal_User extends User implements Initializable  {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label LabelField ;

    private String chosedOption;

    private final String[] Options = {"DisplayTransactionHistory", "ExportStockHistory", "UpdateOrder"};

    private void ShowStage(String name ,ActionEvent event ) throws IOException{
        Parent root = (FXMLLoader.load(getClass().getResource(name)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//     private Account account ;   //until Account class created
    private boolean premium;
   // private ArrayList<Order> transactions = new ArrayList<Order>(); until order class created
//    StockSubject stocksubject;

    @FXML
    public void AfterCancel(ActionEvent event) throws IOException {
        ShowStage("hello-view.fxml",event);
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
                try {
                    ShowStage("ExportHistory.fxml",event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case  "ExportStockHistory":
                try {
                    ShowStage("ExportHistory.fxml",event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case  "UpdateOrder" :
                try {
                    ShowStage("ExportHistory.fxml",event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }

   @Override
    public void  DisplayTransactionHistory(){

    }
    @Override
    public void ExportStockHistory(){ //Stock class parameter

    }

   @Override
   public void UpdateOrder() {

   }



//   @Override
//   public void RetrieveUser(String username) {
//
//   }
//
//   @Override
//   public void UpdateUser(User user) {
//
//   }
//
//   @Override
//    public void DeleteUser(User user) {
//
//   }
//
//   @Override
//   public void CreateStock() {
//
//   }
//
//   @Override
//   public void RetrieveStock() {
//
//   }
//
//   @Override
//   public void UpdateStock() {
//
//   }
//
//   @Override
//   public void DeleteStock() {
//
//   }
//
//   @Override
//   public void UpdateStockPrice(double price) {
//
//   }
//
//   @Override
//   public void UpdateLabel() {
//
//   }
//
//   @Override
//   public void DefineDividend() {
//
//   }
//
//   @Override
//   public void ApprovalSystem() {
//
//   }
//
//   @Override
//   public void InitiateTradingSession() {
//
//   }
//
//   @Override
//   public void CloseTradingSession() {
//
//   }
//
//   @Override
//   public void MovingToNextDay() {
//
//   }

}
