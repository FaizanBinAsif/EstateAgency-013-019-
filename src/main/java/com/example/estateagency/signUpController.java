package com.example.estateagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class signUpController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label wrongLogin;

    public void switchToHome(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene home = new Scene(root);
        stage.setScene(home);
        stage.setTitle("Home");
        stage.show();
    }
    public void signUp(ActionEvent event) throws IOException {

        File credFile = new File("D:\\Estate Agency\\EstateAgency\\src\\main\\java\\com\\example\\estateagency\\credidentials.txt");


        FileWriter credw = new FileWriter(credFile,true);

        String name = username.getText();
        String pass = password.getText();
        String cpass = confirmPassword.getText();

        if (name.isBlank() || pass.isBlank() || cpass.isBlank()) {
            wrongLogin.setText("Enter All Credentials!");
        } else {
            if (pass.matches(cpass)) {
                credw.write(name + "\n" + pass + "\n" );

                switchToHome(event);
            }
            else wrongLogin.setText("Password Does not match!");
        }

        credw.close();

    }
}
