package com.example.carrentalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;



public class LoginKeyController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField email_id;

    @FXML
    private PasswordField pass_id;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        try {
        File file = new File("src/main/resources/login.txt");
        Scanner sc = new Scanner(file);
        HashMap<String, String> login_items = new HashMap<String, String>();
        boolean login_success = false;
        while (sc.hasNext()) {
            login_items.put(sc.next(),sc.next());
        }
        for (Entry<String, String> entry: login_items.entrySet()) {
            if (entry.getValue().equals(email_id.getText()) && entry.getKey().equals(pass_id.getText())) {
                login_success = true;
                root = FXMLLoader.load(getClass().getResource("car_rental.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Car Rental");
                stage.show();
                break;
            }
        }
        if (!login_success) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Invalid input");
            alert1.setHeaderText("Invalid input");
            alert1.setContentText("Please check your email and password and try again!");
            alert1.show();
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onExitButtonClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to exit?");
        if (alert.showAndWait().get() == ButtonType.OK){
            System.exit(0);
        } else {
            alert.close();
        }

    }
}
