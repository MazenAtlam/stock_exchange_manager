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

public class Normal_User extends User   {

    public Normal_User(){
        Normal_User.id_counter++;
        this.id = id_counter;
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
