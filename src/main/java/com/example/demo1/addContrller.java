package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;

public class addContrller {
private int availableTicket=120;
    @FXML
    private TextField id_textflightno, id_textflightname, id_textfrom, id_textcity, id_textdate, id_texttime, id_textairport;
    @FXML
    private TextField id_textfirstclass, id_textbussines, id_texteconomy;

    // Action for Save button
    @FXML
    private void saveFlight(ActionEvent event) {
        // Retrieve input from TextFields
        String flightNo = id_textflightno.getText().trim();
        String flightName = id_textflightname.getText().trim();
        String fromCity = id_textfrom.getText().trim();
        String toCity = id_textcity.getText().trim();
        String date = id_textdate.getText().trim();
        String time = id_texttime.getText().trim();
        String airport = id_textairport.getText().trim();
        String firstClassPriceStr = id_textfirstclass.getText().trim();
        String businessClassPriceStr = id_textbussines.getText().trim();
        String economyClassPriceStr = id_texteconomy.getText().trim();
        String bookedSeat=null;
        // Validate input fields
        if (flightNo.isEmpty() || flightName.isEmpty() || fromCity.isEmpty() || toCity.isEmpty() ||
                date.isEmpty() || time.isEmpty() || airport.isEmpty() || firstClassPriceStr.isEmpty() ||
                businessClassPriceStr.isEmpty() || economyClassPriceStr.isEmpty()) {
            showAlert("Error", "All fields must be filled", AlertType.ERROR);
            return;
        }

        // Convert prices to double
        double firstClassPrice, businessClassPrice, economyClassPrice;
        try {
            firstClassPrice = Double.parseDouble(firstClassPriceStr);
            businessClassPrice = Double.parseDouble(businessClassPriceStr);
            economyClassPrice = Double.parseDouble(economyClassPriceStr);
        } catch (NumberFormatException e) {
            showAlert("Error", "Price fields must be numeric", AlertType.ERROR);
            return;
        }

        // Database insertion logic

        String insertQuery = "INSERT INTO Flight_list (Source, desti, date, Time, Flight_number, Airline, Airport_name, `Economy($)`, `Bussiness($)`, `First_class($)`,AvailableTicket,Bokkedseat)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

        Connection connectDB = DatabaseConnection.databaseLink;

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            // Set parameters for the query
            preparedStatement.setString(1, fromCity);
            preparedStatement.setString(2, toCity);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, time);
            preparedStatement.setString(5, flightNo);
            preparedStatement.setString(6, flightName);
            preparedStatement.setString(7, airport);
            preparedStatement.setDouble(8, economyClassPrice);
            preparedStatement.setDouble(9, businessClassPrice);
            preparedStatement.setDouble(10, firstClassPrice);
            preparedStatement.setDouble(11, availableTicket);
            preparedStatement.setString(12,bookedSeat );

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Show success message if insertion is successful
            if (rowsAffected > 0) {
                showAlert("Success", "Flight has been added successfully!", AlertType.INFORMATION);
            } else {
                showAlert("Error", "Failed to add flight. Please try again.", AlertType.ERROR);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Log for debugging
            showAlert("Database Error", "An error occurred while saving the flight: " + e.getMessage(), AlertType.ERROR);
        }
    }

    // Action for Reset button
    @FXML
    private void clearText(ActionEvent event) {
        id_textflightno.clear();
        id_textflightname.clear();
        id_textfrom.clear();
        id_textcity.clear();
        id_textdate.clear();
        id_texttime.clear();
        id_textairport.clear();
        id_textfirstclass.clear();
        id_textbussines.clear();
        id_texteconomy.clear();
    }

    // Helper function to show alerts
    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
