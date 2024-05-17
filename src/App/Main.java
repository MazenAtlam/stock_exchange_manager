package App;
import App.User.Admin.AdminSceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage currStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.currStage = primaryStage;
        AdminSceneController adminSceneController = new AdminSceneController();
        adminSceneController.display("Temp.fxml");
    }
}
