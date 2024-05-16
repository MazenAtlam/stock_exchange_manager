module com.example.stock_manager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stock_manager to javafx.fxml;
    exports com.example.stock_manager;
}