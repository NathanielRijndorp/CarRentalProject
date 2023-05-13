module com.example.carrentalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.carrentalproject to javafx.fxml;
    exports com.example.carrentalproject;
}