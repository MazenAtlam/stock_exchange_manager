package App.User.Admin;

import java.util.regex.Pattern;
import App.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminToCreateNewUserController extends Controller{
    private Admin currAdmin;

    @FXML
    private Button create;
    @FXML
    private Button cancel;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private TextField ConfirmPassword;

    public void initialize() {
        currAdmin = (Admin) Data.Admins.get(Data.getAdminIndex());
    }
    public void Create(ActionEvent e) {
        String name = Username.getText();
        String pass = Password.getText();
        String confirmPass = ConfirmPassword.getText();
        final boolean checkUsername = Pattern.matches("[A-Za-z]{8,}",name);
        final boolean checkPassword = Pattern.matches("\\w{8,}",pass);

        if (checkUsername && checkPassword && pass.equals(confirmPass) &&
        Data.UsernameIsAvailable(name)) {
            currAdmin.addUser(name, pass);
        }
    }
    public void Cancel(ActionEvent e) {
        display("AdminScene.fxml");
    }

    // private boolean isEmpty(TextField field, String fieldValue) {
    //     if (fieldValue == null || fieldValue == "") {
    //         try {
    //             WarningMessage.show(fieldValue, "Please, " + field.getPromptText());
    //         } catch (IOException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //         return true;
    //     }
    //     return false;
    // }
}
