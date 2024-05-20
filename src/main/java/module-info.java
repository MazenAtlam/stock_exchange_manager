module com.example.stockproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stockproject to javafx.fxml;
    exports com.example.stockproject;
}