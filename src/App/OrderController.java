package App;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderController {
    public static final ObservableList<Order> orderObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Order, String> orderTypeColumn;
    @FXML
    private TableColumn<Order, String> companySymbolColumn;
    @FXML
    private TableColumn<Order, Integer> numberOfOrderedStocksColumn;
    @FXML
    private TableColumn<Order, Double> amountDepositedOrWithdrawnColumn;
    @FXML
    private TableColumn<Order, StringProperty> currentOrderStateColumn;
    @FXML
    private TableView<Order> tableViewOrders;
    @FXML
    private TableView<Order> tableViewOwnedAssets;

    public void initialize() {
        companySymbolColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("companySymbol"));
        orderTypeColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("orderType"));
        numberOfOrderedStocksColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("numberOfOrderedStocks"));
        amountDepositedOrWithdrawnColumn.setCellValueFactory(new PropertyValueFactory<Order, Double>("amountDepositedOrWithdrawn"));
        currentOrderStateColumn.setCellValueFactory(new PropertyValueFactory<Order, StringProperty>("currentOrderState"));
        tableViewOrders.setItems(orderObservableList);
    }
}
