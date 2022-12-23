module com.example.estateagency {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.estateagency to javafx.fxml;
    exports com.example.estateagency;
}