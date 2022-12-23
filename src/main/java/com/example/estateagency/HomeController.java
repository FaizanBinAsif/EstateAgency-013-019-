package com.example.estateagency;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class HomeController {
    public boolean b = false;

    @FXML
    Text text1;

    @FXML
    Text text2;

    @FXML
    Text text3;

    @FXML
    Text text4;

    @FXML
    Text text5;

    @FXML
    Text text6;
    @FXML
    MenuButton menu1;
    @FXML
    MenuButton menu2;
    @FXML
    MenuButton menu3;
    @FXML
    MenuButton menu4;
    @FXML
    MenuButton menu5;
    @FXML
    MenuButton menu6;
    @FXML
    private Button loginBtn1;
    @FXML
    private Button loginBtn2;
    @FXML
    private Button loginBtn3;
    @FXML
    private Button loginBtn4;
    @FXML
    private Button loginBtn5;
    @FXML
    private Button loginBtn6;
    @FXML
    private Label wrongLogin;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private PasswordField password3;
    @FXML
    private PasswordField password4;
    @FXML
    private PasswordField password5;
    @FXML
    private PasswordField password6;
    @FXML
    private Button btn;



    public void addProfile(ActionEvent event) throws IOException{

        int check=0;
        String a="";

        File credFile = new File("D:\\Estate Agency\\EstateAgency\\src\\main\\java\\com\\example\\estateagency\\credidentials.txt");
        Scanner scan = new Scanner(credFile);

        while (scan.hasNext()){
            a = scan.nextLine();

            if (check%2==0){
                    if (check==0){
                        menu1.setDisable(false);
                        text1.setText(a);
                    } else if (check==2) {
                        menu2.setDisable(false);
                        text2.setText(a);
                    }
                    else if (check==4) {
                        menu3.setDisable(false);
                        text3.setText(a);
                    }
                    else if (check==6){
                        menu4.setDisable(false);
                        text4.setText(a);
                    }
                    else if (check==8){
                        menu5.setDisable(false);
                        text5.setText(a);
                    }
                    else if (check==10){
                        menu6.setDisable(false);
                        text6.setText(a);
                    }
                }

            check++;
        }
    }
public void signIn(ActionEvent event) throws IOException{
        btn.setText("");
        this.b = false;
        wrongLogin.setText("");

        String check = "";
        String pass = "";
        String user = "";


    File credFile = new File("D:\\Estate Agency\\EstateAgency\\src\\main\\java\\com\\example\\estateagency\\credidentials.txt");
    Scanner scan = new Scanner(credFile);

    if (event.getSource()==loginBtn1){
        pass = password1.getText();
        user = text1.getText();
    }
    else if (event.getSource()==loginBtn2){
        pass = password2.getText();
        user = text2.getText();
    }
    else if (event.getSource()==loginBtn3){
        pass = password3.getText();
        user = text3.getText();
    }
    else if (event.getSource()==loginBtn4){
        pass = password4.getText();
        user = text4.getText();
    }
    else if (event.getSource()==loginBtn5){
        pass = password5.getText();
        user = text5.getText();
    }
    else if (event.getSource()==loginBtn6){
        pass = password6.getText();
        user = text6.getText();
    }

    else if (pass.isBlank() || user.isBlank()){
        wrongLogin.setText("Enter Password!");
    }

    while (scan.hasNextLine()){
            if (scan.nextLine().equalsIgnoreCase(user)){
                check = scan.nextLine();
            }
    }

    if (pass.equalsIgnoreCase(check)){
        this.b = true;
        btn.setText("Right Password! To Enter Click Here");
    }
    if (pass.equalsIgnoreCase(check)==false){
        wrongLogin.setText("Wrong Password!");
    }

}
public void sign(ActionEvent event) throws IOException{
        if (this.b == true){
            switchToDashboard(event);
        }
}
public void switchToSignUp(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene signUp = new Scene(root);
    stage.setScene(signUp);
    stage.setTitle("Sign Up");
    stage.show();
}
public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene dashboard = new Scene(root);
        stage.setScene(dashboard);
        stage.setTitle("Dashboard");
        stage.show();
}

}