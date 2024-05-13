package com.example.stockproject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public abstract class User {

    public static int Id = 0;
    protected String username;
    protected String password;
    protected int  id ;



    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setId() {
        this.id = Id;
    }
    public int getId() {return id;}



    public String GetUsername() {
        return username;
    }


    public void ChangeUsername(){

    }

    public void ChangePassword(){

    }

    // normal users abstract methods.

    public abstract void DisplayTransactionHistory();
    public abstract void ExportStockHistory(); // there will a parameter from Stock class
    public abstract void UpdateOrder();

    // Admins abstract methods

//    public abstract void RetrieveUser(String username);
//    public abstract void UpdateUser(User user); // Ask about  Parameter Data Type
//    public abstract void DeleteUser(User user);
//    public abstract void CreateStock(); // there will be a parameter from Stock class
//    public abstract void RetrieveStock(); // there will be a parameter from Stock class
//    public abstract void UpdateStock(); // there will be a parameter from Stock class
//    public abstract void DeleteStock(); // there will be a parameter from Stock class
//    public abstract void UpdateStockPrice(double price); // there will be a parameter from Stock class
//    public abstract void UpdateLabel();// there will be a parameter from Stock class and label
//    public abstract void DefineDividend();// there will be a parameter from Stock class and dividend
//    public abstract void ApprovalSystem();// request or order parameter
//    public abstract void InitiateTradingSession();
//    public abstract void CloseTradingSession();
//    public abstract void MovingToNextDay();

}
