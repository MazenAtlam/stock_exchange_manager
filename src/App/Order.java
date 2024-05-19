package App;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

public class Order {
    private String companySymbol = "-";
    private String orderType;
    private String numberOfOrderedStocks = "-";
    private Double amountDepositedOrWithdrawn;
    private final StringProperty currentOrderState = new SimpleStringProperty("Pending");
    public static int flag;

    public String getNumberOfOrderedStocks() {
        return numberOfOrderedStocks;
    }

    public String getCompanySymbol() {
        return companySymbol;
    }
    public String getOrderType() {
        return orderType;
    }

    public Double getAmountDepositedOrWithdrawn() {
        return amountDepositedOrWithdrawn;
    }

    public String getCurrentOrderState() {
        return currentOrderState.get();
    }

    public StringProperty currentOrderStateProperty() {
        return currentOrderState;
    }

    public Order(double amountDepositedOrWithdrawn) {
        if (flag == 1) {
            this.orderType = "Withdraw";
        }
        else {
            this.orderType = "Deposit";
        }
        this.amountDepositedOrWithdrawn = amountDepositedOrWithdrawn;
        OrderController.orderObservableList.add(this);
        ApprovalSystemController.OrderOL.add(this);
    }

    //Should Be Executed if numberOfOrderedStocks > 0
    public Order(String companySymbol, Integer numberOfOrderedStocks, String orderType) {
        this.companySymbol = companySymbol;
        this.numberOfOrderedStocks = numberOfOrderedStocks.toString();
        this.orderType = orderType;
        OrderController.orderObservableList.add(this);
    }

    public static Scene getOrderScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OrderController.class.getResource("Order.fxml"));
        return (new Scene(fxmlLoader.load()));
    }

}
