package com.example.estateagency;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EstateAgency extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader homeLoader = new FXMLLoader(EstateAgency.class.getResource("Home.fxml"));
        Scene home = new Scene(homeLoader.load());


        stage.setTitle("Home");
        stage.setScene(home);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}