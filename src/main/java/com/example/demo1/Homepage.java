package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.format.DateTimeParseException;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Homepage {
@FXML
private Label idticket;
@FXML
private Label idlabel1;
    @FXML
    private Label idlabel11;
    @FXML
    private Label islabel21;
    @FXML
    private Label islabel1;
@FXML
private Label idticket1;
@FXML
private TextField idreservation;
    @FXML
private TextField idreservation1;
    @FXML
private TextField iduser;
    @FXML
private TextField iduser1;
    @FXML
    private VBox id_admin;
    @FXML
    private VBox idroot2;
    @FXML
    private VBox idroot3;
 @FXML
    private VBox idroot31;


    @FXML
    private Button id_btn1;

    @FXML
    private Button id_admin1;

    @FXML
    private Button btn_logout1;

    @FXML
    private Label id_hometitle;

    @FXML
    private Button idFlight;

    @FXML
    private Button idbooking;

    @FXML
    private Button idcheckin;

    @FXML
    private Button idcancel;

    @FXML
    private ComboBox<String> idfrom;

    @FXML
    private ComboBox<String> idto;
    @FXML
    private Button idconcel;
 @FXML
    private Button idconcel1;


    @FXML
    private ComboBox<String> idclass;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button idsearch;

    // Event handler for the "Home" button
    @FXML
    private void handleHomeButton(ActionEvent event) {
        System.out.println("Home button clicked.");
        // Add your logic here
    }

    // Event handler for the "Admin" button
    @FXML
    private void onAdmin(ActionEvent event) {
        System.out.println("Admin button clicked.");
        id_admin1.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("Admin.fxml"));
                root=loader.load();
                // flights flightController=loader.getController();
                //  flightController.setIdTicket(idp,availableSeat);
                stage = (Stage)id_admin1.getScene().getWindow();
                stage.close();
                stage = new Stage();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // Add your logic here
    }

    // Event handler for the "Logout" button
    @FXML
    private void onlogout(ActionEvent event) {
        System.out.println("Logout button clicked.");
        System.out.println("Logout button clicked");
        stage = (Stage) btn_logout1.getScene().getWindow();
        stage.close();
        // Add your logic here
    }

    // Event handler for the "Flight" button
    @FXML
    private void selectbtn(ActionEvent event) {
        System.out.println("Flight button clicked.");
        // Add your logic here
    }

    // Event handler for the "My Booking" button
    @FXML
    private void getdetails(ActionEvent event) {
        System.out.println("My Booking button clicked.");

        idroot31.setVisible(true);
        idroot3.setVisible(false);
        idroot2.setVisible(false);
        // Add your logic here
    }

    // Event handler for the "Check-in" button
    @FXML
    private void gettickets(ActionEvent event) {
        System.out.println("Check-in button clicked.");
        // Add your logic here
    }

    // Event handler for the "Cancel" button
    @FXML
    private void cancel(ActionEvent event) {
        System.out.println("Cancel button clicked.");
        // Add your logic here
        idroot2.setVisible(false);
        idroot31.setVisible(false);
        idroot3.setVisible(true);
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    // Event handler for the "Search" button
    @FXML
    private void searchflight(ActionEvent event) {
        System.out.println("Search button clicked.");

        // Get the values from the UI components
        String from = idfrom.getValue();
        String to = idto.getValue();
        String flightClass = idclass.getValue();
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "No Date Selected";
        if(date!="No Date Selected"){
            if (isDateValid(date)) {
                //showAlert("Success", "The entered date is valid and is greater than or equal to today's date.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "The entered date is invalid or is before today's date.", Alert.AlertType.ERROR);
                return;
            }
       }
        // Check if any required fields are null or empty
        if (from == null || from.isEmpty() || to == null || to.isEmpty() || flightClass == null || flightClass.isEmpty()) {
            // Display error message or alert to the user
            System.out.println("Error: One or more required fields are empty!");
            showError("Departure Destination And Class  fields must be filled.");
            return; // Exit the method if validation fails
        }

        // If validation passes, set the customer details
        customer.cDeparture = from;
        customer.cdestination = to;
        customer.cClass = flightClass;
        customer.cDate = date;

        // Proceed with the search if all inputs are valid
        idsearch.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Flight_list.fxml"));
                root = loader.load();
                stage = (Stage) idsearch.getScene().getWindow();
                stage.close();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Insert clicked");
    }

    // Method to show error message in a dialog
    private void showError(String message) {
        // Create an alert with error type
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(message);

        // Show the alert and wait for the user to close it
        alert.showAndWait();
    }



    @FXML
    public void initialize() {
        // Populate ComboBoxes with 10 different country names


idFlight.setStyle("-fx-background-color: lightgreen");

        idroot2.setVisible(true);
        idroot3.setVisible(false);
        idroot31.setVisible(false);

        idfrom.getItems().addAll(

                "Bangladesh",
                "United Kingdom",
                "Australia",
                "Malasiya",
                "France",
                "United Arab Emirates",
                "Japan",
                "Singapur",
                "Brazil","India","Newzeland","Spain","United States","Srilanka"
        );
        idto.getItems().addAll(

                "Bangladesh",
                "United Kingdom",
                "Australia",
                "Malasiya",
                "France",
                "United Arab Emirates",
                "Japan",
                "Singapur",
                "Brazil","India","Newzeland","Spain","United States","Srilanka"
        );

        // Set ComboBoxes to be editable
        idfrom.setEditable(true);
        idto.setEditable(true);

        // Populate flight class options
        idclass.getItems().addAll("Economy", "Business", "FirstClass");

        System.out.println("Homepage initialized with editable ComboBoxes.");
    }

    @FXML
    public  void  onfind(ActionEvent event) {
        String reserved1 = idreservation1.getText().trim();
        String user1 = iduser1.getText().trim();
        try {

            // Convert reservation number to integer
            long reservedInt = Long.parseLong(reserved1);
            System.out.println("Reserved as integer: " + reservedInt);
        } catch (NumberFormatException e) {
            // Invalid number format for reservation
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for the reservation field.");
            alert.showAndWait();
            return;
        }

        // Database connection
        Connection connectDB = DatabaseConnection.databaseLink;
        String selectQuery = "SELECT * FROM Customer_details WHERE ReservationN0=? AND Username=?";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, Integer.parseInt(reserved1));
            preparedStatement.setString(2, user1);

            ResultSet resultSet = preparedStatement.executeQuery();
            int canceledCount = 0;
            StringBuilder canceledReservations = new StringBuilder();

            // Check if result set has any rows
            if (!resultSet.next()) {
                System.out.println("No reservations found");
                showAlert("No Reservations", "No reservation found for the given details.", Alert.AlertType.INFORMATION);
                return;
            }

            // Process each reservation
            do {
                System.out.println("Processing reservation...");
//                long reservationNo = resultSet.getLong("ReservationN0");
//                Date date1 = resultSet.getDate("Date");
//                Time time2 = resultSet.getTime("Time");
//                String seatNumber = resultSet.getString("SeatNumber");
//                String flightNo = resultSet.getString("FlightNo");

                customer.cUsername=resultSet.getString("Username");
                customer.cDate=resultSet.getString("Date");
                customer.cTime=resultSet.getString("Time");
                customer.cprice=resultSet.getDouble("TicketPrice");
                customer.cClass=resultSet.getString("Class");
                customer.cticketCount=resultSet.getInt("TicketNumber");
                customer.cDeparture=resultSet.getString("Departure");
                //  customer.cbookedTickets=resultSet.getString("SeatNumber");
                //  customer.cAvailableseats=resultSet.getInt("AvailableSeats");
                customer.cdestination=resultSet.getString("Destination");
                customer.updatedTickets=resultSet.getString("SeatNumber");
                customer.nId=resultSet.getString("Nid");
                customer.cPass=resultSet.getString("Passport");
                customer.cEmail=resultSet.getString("Gmail");
                customer.cAirport=resultSet.getString("AirportName");
                customer.cFlightname=resultSet.getString("FlightName");
                customer.cFlightno=resultSet.getString("FlightNo");


            } while (resultSet.next()); // Continue processing remaining rows

            // Show results in an alert
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//            alert.showAndWait();
            try {
                System.out.println("uyjgfker63847638");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("myTicket.fxml"));
                Parent root = loader.load();

                // Uncomment and implement if needed
                // confirmController seat = loader.getController();
                // seat.setIdTicket(idp, flightNo, flightName, fromCity, toCity, date, time,
                // airport, availableSeat, bookedseat, c_lass, updatedTickets, user, email,
                // passport, national);

                Stage stage = (Stage) idconcel1.getScene().getWindow();
                stage.close();
                stage=new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            // Show error alert in case of exceptions
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Database Error");
            errorAlert.setHeaderText("An error occurred");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
            e.printStackTrace();
        }
        idroot2.setVisible(true);
        idroot3.setVisible(false);
        idroot31.setVisible(false);

    }
    @FXML
    public void onconcel(ActionEvent actionEvent) {
        String reserved = idreservation.getText().trim();
        String user = iduser.getText().trim();

        // Validate input fields
        if (reserved.isEmpty() || user.isEmpty()) {
            showAlert("Error", "All fields must be filled", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Convert reservation number to integer
            long reservedInt = Long.parseLong(reserved);
            System.out.println("Reserved as integer: " + reservedInt);
        } catch (NumberFormatException e) {
            // Invalid number format for reservation
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for the reservation field.");
            alert.showAndWait();
            return;
        }

        // Database connection
        Connection connectDB = DatabaseConnection.databaseLink;
        String selectQuery = "SELECT ReservationN0, Date, Time, FlightNo, SeatNumber FROM Customer_details WHERE ReservationN0=? AND Username=?";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, Integer.parseInt(reserved));
            preparedStatement.setString(2, user);

            ResultSet resultSet = preparedStatement.executeQuery();
            int canceledCount = 0;
            StringBuilder canceledReservations = new StringBuilder();

            // Check if result set has any rows
            if (!resultSet.next()) {
                System.out.println("No reservations found");
                showAlert("No Reservations", "No reservation found for the given details.", Alert.AlertType.INFORMATION);
                return;
            }

            // Process each reservation
            do {
                System.out.println("Processing reservation...");
                long reservationNo = resultSet.getLong("ReservationN0");
                Date date1 = resultSet.getDate("Date");
                Time time2 = resultSet.getTime("Time");
                String seatNumber = resultSet.getString("SeatNumber");
                String flightNo = resultSet.getString("FlightNo");

                // Combine Date and Time into a LocalDateTime object
                LocalDate flightDate = date1.toLocalDate();
                LocalTime flightTime = time2.toLocalTime();
                LocalDateTime departureDateTime = LocalDateTime.of(flightDate, flightTime);

                // Get current time
                LocalDateTime currentDateTime = LocalDateTime.now();

                // Calculate the time difference
                Duration duration = Duration.between(currentDateTime, departureDateTime);

                // If remaining time is greater than 24 hours, proceed with cancellation
                if (duration.toHours() > 24) {
                    // Delete customer from Customer_details table
                    String deleteQuery = "DELETE FROM Customer_details WHERE ReservationN0 = ?";
                    try (PreparedStatement deleteStatement = connectDB.prepareStatement(deleteQuery)) {
                        deleteStatement.setLong(1, reservationNo);
                        int rowsAffected = deleteStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            canceledReservations.append("Reservation ID ").append(reservationNo).append(" canceled.\n");
                            canceledCount++;

                            // Update Flight_list table (after successful deletion)
                            String updateFlightQuery = "UPDATE Flight_list SET AvailableTicket = AvailableTicket + 1, " +
                                    "BokkedSeat = REPLACE(REPLACE(BokkedSeat, ?, ''), ',,', ',') WHERE Flight_number = ?";
                            try (PreparedStatement updateStatement = connectDB.prepareStatement(updateFlightQuery)) {
                                updateStatement.setString(1, seatNumber);  // Remove the seat from the list
                                updateStatement.setString(2, flightNo);
                                int rowsUpdated = updateStatement.executeUpdate();

                                if (rowsUpdated > 0) {
                                    System.out.println("Seat removed from Flight_list successfully.");
                                }
                            }
                        }
                    }
                }
            } while (resultSet.next()); // Continue processing remaining rows

            // Show results in an alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (canceledCount > 0) {
                alert.setTitle("Cancellation Results");
                alert.setHeaderText("Flight Cancellations Successful");
                alert.setContentText(canceledReservations.toString());
            } else {
                alert.setTitle("Cancellation Results");
                alert.setHeaderText("No Flights Canceled");
                alert.setContentText("No flights met the cancellation criteria (more than 24 hours before departure).");
            }
            alert.showAndWait();

        } catch (SQLException e) {
            // Show error alert in case of exceptions
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Database Error");
            errorAlert.setHeaderText("An error occurred");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
            e.printStackTrace();
        }

        idroot2.setVisible(true);
        idroot3.setVisible(false);
        idroot31.setVisible(false);

    }

    // Method to show alerts
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean isDateValid(String userInputDate) {
        try {
            // Parse the user input date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate enteredDate = LocalDate.parse(userInputDate, formatter);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Compare the dates
            return !enteredDate.isBefore(currentDate); // Return true if enteredDate >= currentDate
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
            return false;
        }
    }

    public void onHome(ActionEvent actionEvent) {
        System.out.println("Home button clicked");
        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("homepage.fxml"));
            root=loader.load();
            // flights flightController=loader.getController();
            //  flightController.setIdTicket(idp,availableSeat);
//                Stage stage = (Stage)idinsert.getScene().getWindow();
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

    // Method to show alerts


