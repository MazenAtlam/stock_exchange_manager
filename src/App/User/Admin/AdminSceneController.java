package App.User.Admin;

import java.io.IOException;
import App.Controller;
import App.Data;
import App.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class AdminSceneController extends Controller {
    private User currUser;

    @FXML
    private TitledPane viewProfile;
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
    private TextField nameToRetrieve;
    @FXML
    private ListView<String> admins;
    @FXML
    private ListView<String> users;
    @FXML
    private Label username;
    @FXML
    private Label adminID;
    // @FXML
    // private Label gender;

    public void initialized() {
        viewProfile.setExpanded(false);
        currUser = Data.Admins.get(AdminIndex);
        username.setText(currUser.userName);
        adminID.setText(currUser.id);
        // users.getItems().addAll(Data.Users);
        // users.getItems().addAll(Data.Admins);
    }

    public void LogOut(ActionEvent e) throws IOException {
        display("hello-view.fxml");
    }

    public void RetrieveUser(ActionEvent e) throws IOException {
        String usernameRetrieve = nameToRetrieve.getText();

        if (usernameRetrieve == null || usernameRetrieve.equals("")) {
            // warning: Please enter a name
        } else {
            for (User item : Data.deletedUsers) {
                if (item.equals(usernameRetrieve)) {
                    Data.deletedUsers.remove(item);
                    Data.Users.add(item);
                    users.getItems().add(item.userName);
                    return;
                }
            }
            // Warning: This user is not deleted or not found
        }
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

    // public void ChangeGender(ActionEvent e) throws IOException {
    //     if (currUser.gender == MALE);
    // }

    public void ChangePassword(ActionEvent e) throws IOException {
        display("ChangePassword.fxml");
    }

    public void StartSession(ActionEvent e) throws IOException {
        display("Session.fxml");
    }
}
