module com.example.simplyrugbysoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.simplyrugbysoftware to javafx.fxml;
    exports com.example.simplyrugbysoftware;
}