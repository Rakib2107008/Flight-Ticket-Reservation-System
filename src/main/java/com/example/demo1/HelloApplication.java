package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent; // Correct import

import java.io.IOException;

public class HelloApplication extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            // Load the FXML file for the login screen
            Parent root = fxmlLoader.load();

            // Set the stage style to undecorated (no window borders)
//            stage.initStyle(StageStyle.UNDECORATED);

            // Add mouse pressed and dragged events for dragging the window
            root.setOnMousePressed((MouseEvent event) -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });

            // Create a scene with the loaded FXML and set it on the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("");
            stage.setMaxHeight(720);
            stage.setMaxWidth(1280);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
