package App.User.Admin;
import java.io.IOException;

import App.Controller;
import App.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
// import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
// import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AdminSceneController implements Controller {
    private static Parent root;
    private static Scene currScene;
    private static Stage currStage;
    // private static Image image;

    @FXML
    private Button logout;
    @FXML
    private Button startSession;
    @FXML
    private Button createNewUser;
    @FXML
    private Button createNewAdmin;
    @FXML
    private Button delete;
    @FXML
    private Button retrieveUser;
    @FXML
    private MenuItem changeName;
    @FXML
    private MenuItem changePassword;
    @FXML
    private MenuItem changeGender;
    @FXML
    private ListView<User> admins;
    @FXML
    private ListView<User> users;
    @FXML
    private Label username;
    @FXML
    private Label adminID;
    @FXML
    private Label gender;

    public void LogOut(ActionEvent e) throws IOException {
        display("Temp.fxml");
    }

    public void RetrieveUser(ActionEvent e) throws IOException {
        display("Temp.fxml");
    }

    public void DeleteSelected(ActionEvent e) throws IOException {
        display("Temp.fxml");
    }

    public void CreateNewAdmin(ActionEvent e) throws IOException {
        display("AdminCreation.fxml");
    }

    public void CreateNewUser(ActionEvent e) throws IOException {
        display("AdminToCreateNewUser.fxml");
    }

    public void ChangeName(ActionEvent e) throws IOException {
        display("ChangeName.fxml");
    }

    public void ChangeGender(ActionEvent e) throws IOException {
        display("ChangeName.fxml");
    }

    public void ChangePassword(ActionEvent e) throws IOException {
        display("ChangePassword.fxml");
    }

    public void StartSession(ActionEvent e) throws IOException {
        display("Session.fxml");
    }

    @Override
    public void display(String sceneName) {
        try {
            root = FXMLLoader.load(getClass().getResource(sceneName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        currScene = new Scene(root);

        String[] title = sceneName.split("\\.", 2);
        currStage.setTitle(title[0]);
        // stage.getIcons().add(image);
        currStage.setScene(currScene);
        currStage.setResizable(false);
        currStage.show();
    }

    @Override
    public void setCurrStage(Stage stage) {
        AdminSceneController.currStage = stage;
    }
}
