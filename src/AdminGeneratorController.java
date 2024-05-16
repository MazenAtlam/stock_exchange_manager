import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class AdminGeneratorController {

    Stage stage;
    Scene scene;


    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private Label LabelField;

    private String tempForUsername;
    private String tempForPassword;

    private boolean checkUsername , checkPassword;
    @FXML
    private void ShowStage(String name , ActionEvent event ) throws IOException{
        Parent root = (FXMLLoader.load(getClass().getResource(name)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void AfterCreation(ActionEvent event) throws IOException{
        tempForUsername = usernameField.getText();
        checkUsername = Pattern.matches("[A-Za-z]{8,}",tempForUsername);
        tempForPassword = passwordField.getText();
        checkPassword = Pattern.matches("\\w{8,}",tempForPassword);
        if (checkUsername && checkPassword && tempForPassword.equals(confirmPasswordField.getText())) {
            if (Data.AdminNameIsavailable(tempForUsername)) {
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
    public void AfterCancel(ActionEvent event) throws IOException{
        ShowStage("AdminScene.fxml",event);
    }
}
