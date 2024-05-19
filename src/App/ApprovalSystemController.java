package App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ApprovalSystemController {
    public static ObservableList<Order> OrderOL = FXCollections.observableArrayList();
    @FXML
    TableView<Order> orders;
    @FXML
    TableColumn<Order, String> username;
    @FXML
    TableColumn<Order, String> type;
    @FXML
    TableColumn<Order, Double> amount;

    public void initialize() {
        username.setCellValueFactory(new PropertyValueFactory<Order, String>("username"));
        type.setCellValueFactory(new PropertyValueFactory<Order, String>("type"));
        amount.setCellValueFactory(new PropertyValueFactory<Order, Double>("amount"));
        orders.setItems(OrderOL);
    }
}
