module com.example.simplyrugbysoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.example.simplyrugbysoftware to javafx.fxml;
    exports com.example.simplyrugbysoftware;
}