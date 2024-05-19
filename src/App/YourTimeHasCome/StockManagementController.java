package App.YourTimeHasCome;

import java.util.Objects;

import App.Market;

import java.io.IOException;
import App.Data;
import App.WarningMessage;
import App.User.Admin.AdminSceneController;
import App.User.Admin.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class StockManagementController extends Controller{
    private String companySymbol;
    private String parameterName;

    @FXML
    private Button back;
    @FXML
    private Button edit;
    @FXML
    private Button createNewStocks;
    @FXML
    private MenuItem changeName;
    @FXML
    private MenuItem changePassword;
    @FXML
    private Label username;
    @FXML
    private Label adminId;
    @FXML
    private TextField Value;
    @FXML
    private ListView<String> company;
    @FXML
    private TitledPane viewProfile;
    @FXML
    private ListView<String> parameter;

    public void initialize() {
        currUser = Data.Admins.get(Data.TempID);
        username.setText(currUser.getUsername());
        adminId.setText(Objects.toString(currUser.getId()));
        viewProfile.setExpanded(false);
        company.getItems().addAll(Market.companySymbolList);
    }

    public void ChangeName(ActionEvent e) throws IOException {
        display(currUser, "ChangeName.fxml");
    }

    public void ChangePassword(ActionEvent e) throws IOException {
        display(currUser, "ChangePassword.fxml");
    }

    public void Back(ActionEvent e) {
        display(currUser, "Session.fxml");
    }

    public void CreateNewStock(ActionEvent e) {
        display(currUser, "CreateNewStocks.fxml");
    }

    public void Edit(ActionEvent e) {
        String value = Value.getText();

        if (value == null) {
            try {
                WarningMessage.show("EmptyField", "Please assign a vlaue after selecting a pair of company and parameter");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        company.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                companySymbol =  company.getSelectionModel().getSelectedItem();
            }
        });
        parameter.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                parameterName =  parameter.getSelectionModel().getSelectedItem();
            }
        });


    }
}
