package App;
import App.User.Admin.AdminSceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private AdminSceneController adminSceneController = new AdminSceneController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        adminSceneController.setCurrStage(primaryStage);
        adminSceneController.display("Temp.fxml");
    }
}
