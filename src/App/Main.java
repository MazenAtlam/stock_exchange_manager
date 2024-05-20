package App;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage currStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.currStage = primaryStage;

        Data.initStockData();
        TempController Control0 = new TempController();
        Control0.display("Temp.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
