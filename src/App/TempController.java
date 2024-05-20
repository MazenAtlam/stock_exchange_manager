package App;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TempController extends Controller {
    @FXML
    private Button AdminScene;

    public void initialize() {
        Controller.currTitle = currStage.getTitle();
        AdminGenerator gen = AdminGenerator.getAdminGenerator();
        currUser = new Admin("Mazen", "111111111");
        gen.add_admin(currUser);
    }

    public void GotoAdminScene(ActionEvent e) throws IOException {
        display(currUser, "AdminScene.fxml");
        Controller.prevTitle = Controller.currTitle;
    }
}
