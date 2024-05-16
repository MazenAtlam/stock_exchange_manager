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
import java.util.Objects;
import java.util.regex.Pattern;


public class controller {
    boolean CheckerUsername, CheckerPassword ;
    @FXML
    private TextField UserNameField;
    @FXML
    private TextField confirmUsernameField;
    @FXML
    private TextField PasswordField;
    @FXML
    private TextField currentPasswordField;

    @FXML
    private TextField ConfirmPasswordField;
    @FXML
    private Label LabelField ;
    @FXML
    private static Label ShowName;
    public String TempForUsername;
    Stage stage;

    public String TempForPassword,TempForCurrentPassword;

    private void ShowStage(String name ,ActionEvent event ) throws IOException{
        Parent root = (FXMLLoader.load(getClass().getResource(name)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            LabelField.setText("username 8 or more characters only password 8 or more character or numbers");
        }
    }






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
            LabelField.setText("username 8 or more characters only password 8 or more characters or numbers");
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
            LabelField.setText("username 8 or more characters only password 8 or more character or numbers");
        }
    }

    @FXML
    public void ShowNameForAdmin(){
        LabelField.setText(Data.Admins.get(Data.getAdminIndex()).username);
    }

    @FXML
    public  void change_name(ActionEvent event) throws IOException{
        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        if (Objects.equals(TempForPassword , Data.Users.get(Data.getUserIndex()).password)){
            if (Objects.equals(TempForUsername,confirmUsernameField.getText()) && CheckerUsername){
                User.ChangeUsername(TempForUsername,"normal");
                ShowStage("LoginScene.fxml",event);
            }
            else {
                LabelField.setText("please check that pattern must be 8 character or more");
            }
        }
        else {
            LabelField.setText("please check New name equals confirm Name");
        }
    }
    @FXML
    public void change_password(ActionEvent event) throws IOException{
        TempForCurrentPassword = currentPasswordField.getText();
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8}",TempForPassword);
        if (Objects.equals(TempForCurrentPassword , Data.Users.get(Data.getUserIndex()).password)) {
            if (Objects.equals(TempForPassword, ConfirmPasswordField.getText()) && CheckerPassword) {
                User.ChangePassword(TempForCurrentPassword, TempForPassword, "normal");
                ShowStage("LoginScene.fxml", event);
            }
            else {
                LabelField.setText("please check New password equals confirm password");
            }
        }
        else {
            LabelField.setText("please check that pattern must be 8 character or more");
        }
    }
    public void back(ActionEvent event) throws IOException{
        ShowStage("NormalUserScene.fxml",event);
    }

    @FXML
    public  void showName(String username){
        ShowName.setText(username);
    }
}