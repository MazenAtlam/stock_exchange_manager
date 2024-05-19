package App.User.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import App.Data;
import App.User.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class AdminSceneController extends Controller implements Initializable{
    private String selectedUser;
    private String selectedAdmin;
    public ArrayList<String> UsersTemp = new ArrayList<>();
    public ArrayList<String> AdminsTemp = new ArrayList<>();
    private Admin currAdmin;
    private AdminGenerator adminGenerator;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        viewProfile.setExpanded(false);
        // Temp();
        // users.getItems().addAll(UsersTemp);
        // admins.getItems().addAll(AdminsTemp);
        add_items(Data.Admins, admins);
        add_items(Data.Users, users);
        try {
            DeleteSelected(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        adminGenerator = AdminGenerator.getAdminGenerator();
        currAdmin = (Admin) Data.Admins.get(Data.getAdminIndex());
    }

    public void LogOut(ActionEvent e) throws IOException {
        display("hello-view.fxml");
    }

    public void RetrieveUser(ActionEvent e) throws IOException {
        String usernameRetrieve = nameToRetrieve.getText();

        User newUser = currAdmin.retrieveUser(usernameRetrieve);
        users.getItems().add(newUser.getUsername());
    }

    public void DeleteSelected(ActionEvent e) throws IOException {
        users.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                selectedUser =  users.getSelectionModel().getSelectedItem();
            }
        });
        admins.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                selectedAdmin =  admins.getSelectionModel().getSelectedItem();
            }
        });
        User admin = getAdmin(selectedAdmin);
        adminGenerator.remove_admin(admin);
        currAdmin.deleteUser(selectedUser);
    }

    private User getAdmin(String username) {
        for (User admin : Data.Admins) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
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

    public void ChangePassword(ActionEvent e) throws IOException {
        display("ChangePassword.fxml");
    }

    public void StartSession(ActionEvent e) throws IOException {
        display("Session.fxml");
    }

    public void add_items(ArrayList<User> list, ListView<String> listView) {
        for (User item : list) {
            listView.getItems().add(item.getUsername());
        }
    }
}
