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
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String name;
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
        root = (FXMLLoader.load(getClass().getResource(name)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void SwitchToUserLogin(ActionEvent event) throws IOException {
//        root = (FXMLLoader.load(getClass().getResource("LoginScene.fxml")));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        ShowStage("LoginScene.fxml",event);
    }

    @FXML
    public void SwitchToAdminLogin(ActionEvent event) throws IOException {
//        root = (FXMLLoader.load(getClass().getResource("AdminLogin.fxml")));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
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
//                root = (FXMLLoader.load(getClass().getResource("NormalUserScene.fxml")));
//                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
                ShowStage("NormalUserScene.fxml",event);
            } else {
                LabelField.setText("Invalid User name or password ");
            }
        } else {
            LabelField.setText("plz enter username and password pattern must be [1-9][a-z][A-Z] ");
        }
    }

    @FXML
    public void ShowName(){
        LabelField.setText(Data.Users.get(Data.getUserIndex()).GetUsername());
    }

    @FXML
    public void CreateNewAccount(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("createNewaccount.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        ShowStage("createNewaccount.fxml",event);
    }

    @FXML
    public void AfterCreation(ActionEvent event) throws IOException {
        TempForUsername = UserNameField.getText();
        CheckerUsername = Pattern.matches("[A-Za-z]{8,}",TempForUsername);
        TempForPassword = PasswordField.getText();
        CheckerPassword = Pattern.matches("\\w{8}",TempForPassword);
        if (CheckerUsername && CheckerPassword && TempForPassword.equals(ConfirmPasswordField.getText())) {
//            System.out.println(TempForUsername +"  " + TempForPassword);
            if (Data.UsernameIsAvailable(TempForUsername)) {
                Data.setUsers(TempForUsername, TempForPassword);
//                root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
//                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
                ShowStage("LoginScene.fxml",event);
            } else {
                LabelField.setText("Invalid User name Please Try Again");
            }
        } else {
            LabelField.setText("Plz enter the three fields and make sure pass == confirm pass");
        }

    }

    @FXML
    public void AfterCancel(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
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
//                root = (FXMLLoader.load(getClass().getResource("NormalUserScene.fxml")));
//                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
                ShowStage("NormalUserScene.fxml",event);
            }
        }
        else{
            LabelField.setText("error");
        }
    }

    @FXML
    public void ShowNameForAdmin() throws IOException{
        LabelField.setText("Data.Admins.get(Data.getAdminIndex()).username)");
    }
}