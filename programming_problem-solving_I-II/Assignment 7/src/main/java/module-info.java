module com.assignment7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assignment7 to javafx.fxml;
    exports com.assignment7;
}