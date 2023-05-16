module com.example.simplyrugbysoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.example.simplyrugbysoftware to javafx.fxml;
    exports com.example.simplyrugbysoftware;
    exports com.example.simplyrugbysoftware.controllers;
    opens com.example.simplyrugbysoftware.controllers to javafx.fxml;
    exports com.example.simplyrugbysoftware.tests;
    opens com.example.simplyrugbysoftware.tests to javafx.fxml;
}