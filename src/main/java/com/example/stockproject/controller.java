package com.example.stockproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Pattern;


public class controller {
    boolean CheckerUsername, CheckerPassword ;
    @FXML
    private TextField UserNameField;
    @FXML
    private TextField PasswordField;
    @FXML
    private TextField ConfirmPasswordField;
    @FXML
    private Label LabelField ;
    public String TempForUsername;
    public String TempForPassword;

    private void ShowStage(String name ,ActionEvent event ) throws IOException{
        Parent root = (FXMLLoader.load(getClass().getResource(name)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void SwitchToUserLogin(ActionEvent event) throws IOException {
        ShowStage("LoginScene.fxml",event);
    }

    @FXML
    public void SwitchToAdminLogin(ActionEvent event) throws IOException {
        ShowStage("AdminLogin.fxml",event);
    }

    @FXML
    public void LogIn(ActionEvent event) throws IOException {

        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8,}",TempForPassword);
        if (CheckerUsername && CheckerPassword) {
            if ( Data.VerifyLogin(TempForUsername, TempForPassword)) {
             ShowStage("NormalUserScene.fxml",event);
            } else {
                LabelField.setText("Invalid User name or password ");
            }
        } else {
            LabelField.setText("Invalid input");
        }
    }

//    @FXML
//    public void ShowName(){
//        LabelField.setText(Data.Users.get(Data.getUserIndex()).GetUsername());
//    }

    @FXML
    public void CreateNewAccount(ActionEvent event) throws IOException {
        ShowStage("createNewaccount.fxml",event);
    }

    @FXML
    public void AfterCreation(ActionEvent event) throws IOException {
        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8}",TempForPassword);
        if (CheckerUsername && CheckerPassword && TempForPassword.equals(ConfirmPasswordField.getText())) {
            if (Data.UsernameIsAvailable(TempForUsername)) {
                Data.setUsers(TempForUsername, TempForPassword);
                ShowStage("LoginScene.fxml",event);
            } else {
                LabelField.setText("Invalid User name Please Try Again");
            }
        } else {
            LabelField.setText("Invalid input");
        }

    }

    @FXML
    public void AfterCancel(ActionEvent event) throws IOException {
        ShowStage("hello-view.fxml",event);
    }



    @FXML
    public void AdminLogin(ActionEvent event) throws IOException {
        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8}",TempForPassword);
        if (CheckerUsername && CheckerPassword) {
            if (Data.VerifyAdminLogin(TempForUsername, TempForPassword)) {
                ShowStage("AdminScene.fxml",event);
            }
        }
        else{
            LabelField.setText("error");
        }
    }

    @FXML
    public void ShowNameForAdmin(){
        LabelField.setText(Data.Admins.get(Data.getAdminIndex()).username);
    }
}