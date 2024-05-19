package App.User.Admin;

import java.io.IOException;

import App.Data;
import App.User.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Controller {
    protected final Stage currStage = Main.currStage;
    protected Scene currScene;
    protected Parent root;
    protected User currUser;

    public void display(User user, String sceneName) {
        Data.TempID = user.getId();

        try {
            root = FXMLLoader.load(getClass().getResource(sceneName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        currScene = new Scene(root);

        String[] title = sceneName.split("\\.", 2);
        currStage.setTitle(title[0]);
        // currStage.getIcons().add(image);
        currStage.setScene(currScene);
        currStage.setResizable(false);
        currStage.show();
    }

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
        // currStage.getIcons().add(image);
        currStage.setScene(currScene);
        currStage.setResizable(false);
        currStage.show();
    }
}
