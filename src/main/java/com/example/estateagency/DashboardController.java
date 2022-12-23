package com.example.estateagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private Pane plotsPane,POSPane,expandituresPane,summaryPane;
    @FXML
    private Button plotsBtn,POSBtn,expandituresBtn,summaryBtn;


    public void PanelButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == plotsBtn){
            plotsPane.toFront();
        }
        else if (event.getSource() == POSBtn){
            POSPane.toFront();
        }
        else if (event.getSource() == expandituresBtn){
            expandituresPane.toFront();
        }
        else if (event.getSource() == summaryBtn){
            summaryPane.toFront();
        }
    }

    public void switchToAddPlotPanel(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AddPanel.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene addPanel = new Scene(root);
        stage.setScene(addPanel);
        stage.setTitle("Add Plots Panel");
        stage.show();
    }

}
