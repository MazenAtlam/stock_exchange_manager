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

public class AdminController {
    private Stage stage;
    // private Image image;
    public Parent root;
    public Scene currScene;
    public Stage currStage;

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

    public void display(String sceneName) throws IOException {
        root = FXMLLoader.load(getClass().getResource(sceneName));
        currScene = new Scene(root);

        String[] title = sceneName.split("\\.", 2);
        System.out.println("start");
        System.out.println(title[0] + " " + title[1]);
        currStage.setTitle(title[0]);
        // stage.getIcons().add(image);
        currStage.setScene(currScene);
        currStage.setResizable(false);
        currStage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        if (stage != null)
            this.stage = stage;
    }

    public void T(ActionEvent e) throws IOException {
        display("AdminCreation.fxml");
    }
}
