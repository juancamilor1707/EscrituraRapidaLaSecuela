module com.example.escriturarapidalasecuela {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.escriturarapidalasecuela to javafx.fxml;
    exports com.example.escriturarapidalasecuela;
}