module com.example.escriturarapida {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.escriturarapida to javafx.fxml;
    exports com.example.escriturarapida;
}