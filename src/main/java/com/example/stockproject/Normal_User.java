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
import java.util.ResourceBundle;

public class Normal_User extends User implements Initializable  {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label LabelField ;
    Stage stage;
    Parent root;
    Scene scene;
    FXMLLoader loader = new FXMLLoader();

    private String chosedOption;
    private String username ;

    private final String[] Options = {"DisplayTransactionHistory", "ExportStockHistory", "UpdateOrder"};

    private void ShowStage(String name ,ActionEvent event ) throws IOException{
         root = (FXMLLoader.load(getClass().getResource(name)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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



    @FXML
    public void changeToMarket(ActionEvent event) throws IOException{
        ShowStage("Market.fxml",event);
    }
    @FXML
    public void changeToAccount(ActionEvent event) throws IOException{
        ShowStage("Market.fxml",event);
    }

    @FXML
    public void changeName(ActionEvent event) throws IOException{
        ShowStage("ChangeName.fxml",event);
//            FXMLLoader loader =new FXMLLoader( getClass().getClassLoader().getResource("ChangeName.fxml"));
//            root = loader.load();
//            controller controller = loader.getController();
//            controller.showName(Data.Users.get(Data.getUserIndex()).username);
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
    }
    @FXML
    public void changePassword(ActionEvent event) throws IOException{
        ShowStage("ChangePassword.fxml",event);

    }
//
//    public void  DisplayTransactionHistory() {
//
//    }
//
//    public void ExportStockHistory(){ //Stock class parameter
//
//    }
//
//
//   public void UpdateOrder() {
//
//   }

}
