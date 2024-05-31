module com.lab8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab8 to javafx.fxml;
    exports com.lab8;
}