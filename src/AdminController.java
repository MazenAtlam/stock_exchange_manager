import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
// import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AdminController implements Controller {
    private static Parent root;
    private static Scene currScene;
    private static Stage currStage;
    // private static Image image;

    @FXML
    private Button logout;
    @FXML
    private Button createNewUser;
    @FXML
    private Button createNewAdmin;
    @FXML
    private MenuItem changeName;
    @FXML
    private MenuItem changePassword;
    @FXML
    private ListView<Order> orders;
    @FXML
    private Label username;
    @FXML
    private Label adminID;
    @FXML
    private Label gender;
    @FXML
    private Label no_of_stocks;

    public void logOut(ActionEvent e) throws IOException {
        display("hello-view.fxml");
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

    public void setCurrStage(Stage stage) {
        AdminController.currStage = stage;
    }

    public void T(ActionEvent e) throws IOException {
        display("AdminCreation.fxml");
    }
}
