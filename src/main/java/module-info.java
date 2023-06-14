module com.example.kantor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.json;

    opens com.example.kantor to javafx.fxml;
    exports com.example.kantor;
}