module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires mysql.connector.java;


    opens sample to javafx.fxml;
    exports sample;
    opens Controllers;
    exports Controllers;
}