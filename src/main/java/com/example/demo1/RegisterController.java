package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView IDimage;  // ImageView for displaying an image
    @FXML
    private Label IDname;
    @FXML
    private Label IDemail;
    @FXML
    private Label IDpassword;
    @FXML
    private TextField textname; // TextField for the user's name
    @FXML
    private TextField textemail; // TextField for the user's email
    @FXML
    private PasswordField textpassword; // PasswordField for the user's password
    @FXML
    private Label IdRegistration; // Label for registration feedback
    @FXML
    private Button IDregisterbutton; // Button for user registration

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set an image for the ImageView (update the path to match your project structure)
        File imageFile = new File("D:\\javaFx_projects\\demo1\\src\\main\\resources\\com\\example\\demo1\\sinup.png");
        if (imageFile.exists()) {
            Image image = new Image(imageFile.toURI().toString());
            IDimage.setImage(image);
        } else {
            System.err.println("Image file not found: " + imageFile.getPath());
        }
    }

    // Method to register the user in the database
    public void registerUser(ActionEvent event) {
        // Get user input from text fields
        String name = textname.getText().trim();
        String email = textemail.getText().trim();
        String password = textpassword.getText().trim();

        // Input validation
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Validation Error", "All fields are required. Please fill them out.", Alert.AlertType.WARNING);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.-]+$")) {
            showAlert("Validation Error", "Invalid email format. Please provide a valid email address.", Alert.AlertType.WARNING);
            return;
        }
        else if( password.length() < 6){
            showAlert("Validation Error", "must contain atleast 6 digit", Alert.AlertType.WARNING);
            return;
        }

        // SQL insert statement
        String insertQuery = "INSERT INTO Usertable (Username, Email, Password) VALUES (?, ?, ?)";

        // Database connection
        Connection connectDB = DatabaseConnection.databaseLink;

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            // Set parameters for the query
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            // Show success or error message based on the result
            if (rowsAffected > 0) {
                showAlert("Success", "User has been registered successfully!", Alert.AlertType.INFORMATION);
                clearFields(); // Clear the fields after successful registration
                try {
                    FXMLLoader loader =new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent root=loader.load();
                    // flights flightController=loader.getController();
                    //  flightController.setIdTicket(idp,availableSeat);
                    Stage stage = (Stage)IDregisterbutton.getScene().getWindow();
                    stage.close();
                    stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                showAlert("Error", "Registration failed. Please try again.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Log the error for debugging
            showAlert("Database Error", "An error occurred while saving user details: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // Method to show an alert dialog
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to clear the input fields after successful registration
    private void clearFields() {
        textname.clear();
        textemail.clear();
        textpassword.clear();
    }
}
