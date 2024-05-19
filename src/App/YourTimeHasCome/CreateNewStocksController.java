package App.YourTimeHasCome;

import App.Data;
import App.User.Admin.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateNewStocksController extends Controller{
    @FXML
    private TextField CompanySymbol;
    @FXML
    private TextField StockPrice;
    @FXML
    private TextField no_of_stocks;
    @FXML
    private Button create;
    @FXML
    private Button cancel;

    public void initialize() {
        currUser = Data.Admins.get(Data.TempID);
    }

    public void Create(ActionEvent e) {
        // Gad Section -> Company
    }
    public void Cancel(ActionEvent e) {
        display(currUser, "StockManagement.fxml");
    }
}
