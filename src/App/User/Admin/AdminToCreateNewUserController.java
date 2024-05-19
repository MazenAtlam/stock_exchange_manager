package App.User.Admin;

import java.util.regex.Pattern;
import App.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminToCreateNewUserController extends Controller{
    @FXML
    private Button create;
    @FXML
    private Button cancel;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPassword;

    public void initialize() {
        currUser = Data.Admins.get(Data.TempID);
    }
    public void Create(ActionEvent e) {
        String name = Username.getText();
        String pass = Password.getText();
        String confirmPass = ConfirmPassword.getText();
        final boolean checkUsername = Pattern.matches("[A-Za-z]{8,}",name);
        final boolean checkPassword = Pattern.matches("\\w{8,}",pass);

        if (checkUsername && checkPassword && pass.equals(confirmPass) &&
        Data.UsernameIsAvailable(name)) {
            Admin currAdmin = (Admin) currUser;
            currAdmin.addUser(name, pass);
        }
    }
    public void Cancel(ActionEvent e) {
        display(currUser, "AdminScene.fxml");
    }
}
