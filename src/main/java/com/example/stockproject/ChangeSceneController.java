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


public class ChangeSceneController extends Controller {
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

    public String TempForUsername;
//    Stage stage;

    public String TempForPassword,TempForCurrentPassword;





    @FXML
    public void SwitchToUserLogin(ActionEvent event) throws IOException {

        display("LoginScene.fxml");
    }

    @FXML
    public void SwitchToAdminLogin(ActionEvent event) throws IOException {

        display("AdminLogin.fxml");
    }

    @FXML
    public void LogIn(ActionEvent event) throws IOException {

        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8,}",TempForPassword);
        if (CheckerUsername && CheckerPassword) {
            if ( Data.VerifyLogin(TempForUsername, TempForPassword)) {
                display("NormalUserScene.fxml");
            } else {
                LabelField.setText("Invalid User name or password ");
            }
        } else {
            LabelField.setText("username 8 or more characters only password 8 or more character or numbers");
        }
    }






    @FXML
    public void CreateNewAccount(ActionEvent event) throws IOException {

        display("createNewaccount.fxml");
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

            display("LoginScene.fxml");
        } else {
            LabelField.setText("Invalid User name Please Try Again");
        }
    } else {
        LabelField.setText("username 8 or more characters only password 8 or more characters or numbers");
    }

}

    @FXML
    public void AfterCancel(ActionEvent event) throws IOException {

        display("hello-view.fxml");
    }



    @FXML
    public void AdminLogin(ActionEvent event) throws IOException {
        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8}",TempForPassword);
        if (CheckerUsername && CheckerPassword) {
            if (Data.VerifyAdminLogin(TempForUsername, TempForPassword)) {

                display("AdminScene.fxml");
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
    public  void change_name(ActionEvent event) throws IOException {
        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        if (Objects.equals(TempForPassword , Data.Users.get(Data.getUserIndex()).password)){
            if (Objects.equals(TempForUsername,confirmUsernameField.getText()) && CheckerUsername){
                User.ChangeUsername(TempForUsername,"normal");

                display("LoginScene.fxml");
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
                display("LoginScene.fxml");
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
        display("NormalUserScene.fxml");
    }



//    @FXML
//    public  void showName(String username){
//        ShowName.setText(username);
//    }


}