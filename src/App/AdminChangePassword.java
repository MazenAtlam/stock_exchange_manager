package App;

import java.util.regex.Pattern;
import App.User.Admin.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class AdminChangePassword extends Controller{
    @FXML
    private Button change;
    @FXML
    private Button cancel;
    @FXML
    private Label currName;
    @FXML
    private PasswordField OldPassword;
    @FXML
    private PasswordField NewPassword;
    @FXML
    private PasswordField ConfirmPassword;

    public void initialize() {
        currUser = Data.Users.get(Data.TempID);
        currName.setText(currUser.getUsername());
    }

    public void Change(ActionEvent e) {
        String o_pass = OldPassword.getText();
        String n_pass = NewPassword.getText();
        String confirmPass = ConfirmPassword.getText();
        final boolean check1 = Pattern.matches("\\w{8,}",o_pass);
        final boolean check2 = Pattern.matches("\\w{8,}",n_pass);
        final boolean check3 = Pattern.matches("\\w{8,}",confirmPass);

        if (check1 && check2 && check3 && n_pass.equals(confirmPass) && Data.VerifyLogin(currUser.getUsername(), o_pass)) {
            currUser.setPassword(n_pass);
        }
    }

    public void Cancel(ActionEvent e) {
        display(currUser, "AdminLogin.fxml");
    }
}
