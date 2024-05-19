package App.YourTimeHasCome;

import App.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ApprovalSystemController {
    public static ObservableList<Order> OrderOL = FXCollections.observableArrayList();

    @FXML
    private Button approve;
    @FXML
    private Button reject;
    @FXML
    private Button back;
    @FXML
    private MenuItem changeName;
    @FXML
    private MenuItem changePassword;
    @FXML
    private Label username;
    @FXML
    private Label adminID;
    @FXML
    private TableView<Order> orders;
    @FXML
    private TableColumn<Order, String> usernameList;
    @FXML
    private TableColumn<Order, String> type;
    @FXML
    private TableColumn<Order, Double> amount;

    public void initialize() {
        usernameList.setCellValueFactory(new PropertyValueFactory<Order, String>("usernameList"));
        type.setCellValueFactory(new PropertyValueFactory<Order, String>("type"));
        amount.setCellValueFactory(new PropertyValueFactory<Order, Double>("amount"));
        orders.setItems(OrderOL);
    }
}
