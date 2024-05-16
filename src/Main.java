import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private AdminController adminController = new AdminController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        adminController.setCurrStage(primaryStage);
        adminController.display("Temp.fxml");
    }
}
