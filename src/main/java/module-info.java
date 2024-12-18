module com.example.demo1 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires javafx.web;
    requires java.net.http;
    requires java.desktop;
    requires java.mail;
    //exports sample to javafx.fxml;

    //opens sample to javafx.fxml;
    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;


}