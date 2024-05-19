package App;

import App.User.Admin.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class AdminChangeName extends Controller{
    @FXML
    private Button change;
    @FXML
    private Button cancel;
    @FXML
    private Label currName;
    @FXML
    private TextField newName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField ConfirmName;

    public void initialize() {
        currUser = Data.Users.get(Data.TempID);
        currName.setText(currUser.getUsername());
    }

    public void Change(ActionEvent e) {
        String name = newName.getText();
        String pass = password.getText();
        String confirmName = ConfirmName.getText();
        final boolean checkUsername = Pattern.matches("[A-Za-z]{8,}",name);

        if (checkUsername && name.equals(confirmName) && Data.VerifyLogin(currUser.getUsername(), pass)) {
            currUser.setUsername(name);
        }
    }

    public void Cancel(ActionEvent e) {
        display(currUser, "AdminLogin.fxml");
    }
}
