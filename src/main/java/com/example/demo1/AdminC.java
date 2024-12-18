package com.example.demo1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AdminC implements Initializable {

    @FXML
    private ImageView IDloginimage;
    @FXML
    private Label IDusername;
    @FXML
    private Label IDpassword;
    @FXML
    private TextField textusername;
    @FXML
    private PasswordField textpassword;
    @FXML
    private Button IDloginbutton;
    @FXML
    private Button IDregisterbutton;
    @FXML
    private Button idback;
    @FXML
    private Label invalidLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load login image
        File imageFile = new File("src/main/resources/com/example/demo1/Admin.png");
        if (imageFile.exists()) {
            Image image = new Image(imageFile.toURI().toString());
            IDloginimage.setImage(image);
        } else {
            System.err.println("Login image not found: " + imageFile.getPath());
        }
    }

    public void onlogin(javafx.event.ActionEvent event) {
        if (!textusername.getText().isBlank() && !textpassword.getText().isBlank()) {
            validateLogin();

        } else {
            showAlert("Validation Error", "Please enter both username and password.", Alert.AlertType.WARNING);
        }
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    private void validateLogin() {
        Connection connectDB = DatabaseConnection.databaseLink;

        // Use parameterized query to prevent SQL injection
        String verifyLogin = "SELECT COUNT(1) FROM Admin_table WHERE Username = ? AND Password = ?";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogin)) {
            preparedStatement.setString(1, textusername.getText().trim());
            preparedStatement.setString(2, textpassword.getText().trim());

            ResultSet queryResult = preparedStatement.executeQuery();

            if (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    showAlert("Login Success", "You have successfully logged in!", Alert.AlertType.INFORMATION);
                    try {
                        FXMLLoader loader =new FXMLLoader(getClass().getResource("Admin_fxml.fxml"));
                        Parent root=loader.load();
                        // flights flightController=loader.getController();
                        //  flightController.setIdTicket(idp,availableSeat);
                         stage = (Stage)IDloginbutton.getScene().getWindow();
                        stage.close();
                        stage = new Stage();
                         scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    showAlert("Login Failed", "Invalid username or password. Please try again.", Alert.AlertType.ERROR);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while connecting to the database: " + e.getMessage(), Alert.AlertType.ERROR);
        }

    }






    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void Back(ActionEvent actionEveent) {

        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();
            // flights flightController=loader.getController();
            //  flightController.setIdTicket(idp,availableSeat);

            Stage stage = (Stage)idback.getScene().getWindow();
            stage.close();
            stage = new Stage();
            stage.close();
            stage.close();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("next  clicked");


    }
}
