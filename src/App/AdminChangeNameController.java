package App;

import App.User.User;
import App.User.Admin.Admin;
import App.User.Admin.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class AdminChangeNameController extends Controller{
    private User currAdmin;

    @FXML
    private Button change;
    @FXML
    private Button cancel;
    @FXML
    private Label currName;
    @FXML
    private TextField newName;
    @FXML
    private TextField password;
    @FXML
    private TextField ConfirmName;

    public void initialize() {
        currAdmin = (Admin) Data.Admins.get(Data.getAdminIndex());
        currName.setText(currAdmin.getUsername());
    }

    public void Change(ActionEvent e) {
        String name = newName.getText();
        String pass = password.getText();
        String confirmName = ConfirmName.getText();
        final boolean checkUsername = Pattern.matches("[A-Za-z]{8,}",name);

        // change NAME
            // if (checkUsername && checkPassword && pass.equals(confirmPass) &&
            // Data.UsernameIsAvailable(name)) {
            //     currAdmin.addUser(name, pass);
            // }
    }

    public void Cancel(ActionEvent e) {
        display("AdminLogin.fxml");
    }
}
