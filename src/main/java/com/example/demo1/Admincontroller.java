package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Admincontroller implements Initializable {

    // FXML fields for elements from the FXML file
    @FXML
    private ImageView idAdminlogo, idimg1, idimg2, idimg3;  // Admin logo and ImageViews for buttons
    @FXML
    private Label idlabel, adminlabel;       // Labels
    @FXML
    private Button idflightlist, idcustomer, idsinout, idinsert, iddelete;    // Buttons
    @FXML
    private TextField idsearch, idsearch2;     // Search text fields
    @FXML
    private TableView<FlightList> idtable;   // Table view for flight management
    @FXML
    private TableColumn<FlightList, String> iddep, iddes, idfli, idairline, iddate, idtime, idair; // Flight columns
    @FXML
    private TableView<customerList> idTable2;  // TableView for customer list
    @FXML
    private TableColumn<customerList, String> idCusname, idDep1, iddes2, idFli2, idAir2, idDate2, idTime2;  // Customer columns
    @FXML
    private TableColumn<customerList, Double> idprice; // Customer price column

    @FXML
    private VBox idAddFlight, idCustomerdetail;       // VBox sections for flight and customer details

    // Initialize method (required by Initializable interface)
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set Admin logo image
        File imageFile = new File("src/main/resources/com/example/demo1/Admin.png");
        idAdminlogo.setImage(new Image(imageFile.toURI().toString()));

        // Set images for buttons/icons (if needed)
        idimg1.setImage(new Image(new File("src/main/resources/com/example/demo1/add.png").toURI().toString()));
        idimg2.setImage(new Image(new File("src/main/resources/com/example/demo1/add.png").toURI().toString()));
        idimg3.setImage(new Image(new File("src/main/resources/com/example/demo1/lout.png").toURI().toString()));

        // Initialize the flight table and customer table
        showTable();
    }

    // Fetch flight data from the database
    public ObservableList<FlightList> flightList() {
        ObservableList<FlightList> flightL = FXCollections.observableArrayList();
        Connection connectDB = DatabaseConnection.databaseLink;
        String query = "SELECT * FROM Flight_list";

        try (Statement statement = connectDB.createStatement();
             ResultSet queryResult = statement.executeQuery(query)) {
            while (queryResult.next()) {
                FlightList flight = new FlightList(
                        queryResult.getInt("id"),
                        queryResult.getString("desti"),
                        queryResult.getString("Source"),
                        queryResult.getString("Flight_number"),
                        queryResult.getString("Airline"),
                        queryResult.getString("date"),
                        queryResult.getString("Time"),
                        queryResult.getString("Airport_name"),
                        queryResult.getDouble("Economy($)"),
                        queryResult.getDouble("First_class($)"),
                        queryResult.getDouble("Bussiness($)"),
                        queryResult.getInt("AvailableTicket"),
                        queryResult.getString("Bokkedseat"));
                flightL.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightL;
    }

    private ObservableList<FlightList> flights;

    // Display flight table
    void showTable() {
        flights = flightList();
        iddep.setCellValueFactory(new PropertyValueFactory<>("departure"));
        iddes.setCellValueFactory(new PropertyValueFactory<>("destination"));
        idfli.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
        idairline.setCellValueFactory(new PropertyValueFactory<>("airline"));
        iddate.setCellValueFactory(new PropertyValueFactory<>("date"));
        idtime.setCellValueFactory(new PropertyValueFactory<>("time"));
        idair.setCellValueFactory(new PropertyValueFactory<>("airport"));
        idtable.setItems(flights);
    }

    // Fetch customer data from the database
    public ObservableList<customerList> custList() {
        ObservableList<customerList> custL = FXCollections.observableArrayList();
        Connection connectDB = DatabaseConnection.databaseLink;
        String query = "SELECT * FROM Customer_details";

        try (Statement statement = connectDB.createStatement();
             ResultSet queryResult = statement.executeQuery(query)) {
            while (queryResult.next()) {
                customerList cust = new customerList(
                        queryResult.getString("Username"),
                        queryResult.getString("Gmail"),
                        queryResult.getString("passport"),
                        queryResult.getString("Nid"),
                        queryResult.getString("Class"),
                        queryResult.getInt("TicketNumber"),
                        queryResult.getString("Departure"),
                        queryResult.getString("destination"),
                        queryResult.getString("Date"),
                        queryResult.getString("Time"),
                        queryResult.getString("AirportName"),
                        queryResult.getString("FlightName"),
                        queryResult.getString("FlightNo"),
                        queryResult.getString("SeatNumber"),
                        queryResult.getDouble("TicketPrice"),
                        queryResult.getInt("ReservationN0"));
                custL.add(cust);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custL;
    }

    private ObservableList<customerList> customers;

    // Display customer table
    void showcustTable() {
        customers = custList();
        idDep1.setCellValueFactory(new PropertyValueFactory<>("cuDeparture"));
        iddes2.setCellValueFactory(new PropertyValueFactory<>("cuDestination"));
        idFli2.setCellValueFactory(new PropertyValueFactory<>("cuFlightNo"));
        idAir2.setCellValueFactory(new PropertyValueFactory<>("cuFlightName"));
        idDate2.setCellValueFactory(new PropertyValueFactory<>("cuDate"));
        idTime2.setCellValueFactory(new PropertyValueFactory<>("cuTime"));
        idCusname.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        idprice.setCellValueFactory(new PropertyValueFactory<>("cuPrice"));
        idTable2.setItems(customers);
    }

    // Action handler for flight management button
    @FXML
    private void flightManage(ActionEvent event) {
        idAddFlight.setVisible(true);
        idCustomerdetail.setVisible(false);
        showTable();
    }

    // Action handler for customer list button
    @FXML
    private void custList(ActionEvent event) {
        idAddFlight.setVisible(false);
        idCustomerdetail.setVisible(true);
        showcustTable();
    }

    // Action handler for sign out button
    @FXML
    private void signOut(ActionEvent event) {
        System.out.println("Sign out clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) idsinout.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Action handler for insert button (flight)
    @FXML
    private void insert(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Search flights handler
    @FXML
    private void Searchflights() {
        FilteredList<FlightList> filteredData = new FilteredList<>(flights, p -> true);
        idsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(predicateFlightList -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                return predicateFlightList.getFlightNo().toLowerCase().contains(searchKey) ||
                        predicateFlightList.getAirline().toLowerCase().contains(searchKey) ||
                        predicateFlightList.getDate().toLowerCase().contains(searchKey) ||
                        predicateFlightList.getTime().toLowerCase().contains(searchKey) ||
                        predicateFlightList.getAirport().toLowerCase().contains(searchKey) ||
                        predicateFlightList.getDeparture().toLowerCase().contains(searchKey) ||
                        predicateFlightList.getDestination().toLowerCase().contains(searchKey);
            });
        });
        SortedList<FlightList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(idtable.comparatorProperty());
        idtable.setItems(sortedData);
    }

    // Search customer handler
    @FXML
    private void searchFlights2() {
        FilteredList<customerList> filteredData = new FilteredList<>(customers, p -> true);
        idsearch2.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(predicatecustomerList -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                return predicatecustomerList.getCuFlightNo().toLowerCase().contains(searchKey) ||
                        predicatecustomerList.getCuFlightName().toLowerCase().contains(searchKey) ||
                        predicatecustomerList.getCuDate().toLowerCase().contains(searchKey) ||
                        predicatecustomerList.getCuTime().toLowerCase().contains(searchKey) ||
                        predicatecustomerList.getCustomerName().toLowerCase().contains(searchKey) ||
                        predicatecustomerList.getCuDeparture().toLowerCase().contains(searchKey) ||
                        predicatecustomerList.getCuDestination().toLowerCase().contains(searchKey);
            });
        });
        SortedList<customerList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(idTable2.comparatorProperty());
        idTable2.setItems(sortedData);
    }

    // Delete a flight from the database
    @FXML
    private void delete(ActionEvent event) {
        FlightList flight = idtable.getSelectionModel().getSelectedItem();
        if (flight == null) {
            showAlert("Error", "Please select a flight to delete.", Alert.AlertType.ERROR);
            return;
        }

        String query = "DELETE FROM Flight_list WHERE Source=? AND desti=? AND date=? AND Time=? AND Flight_number=? AND Airline=? AND Airport_name=?";
        try (Connection connectDB = DatabaseConnection.databaseLink;
             PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
            preparedStatement.setString(1, flight.getDeparture());
            preparedStatement.setString(2, flight.getDestination());
            preparedStatement.setString(3, flight.getDate());
            preparedStatement.setString(4, flight.getTime());
            preparedStatement.setString(5, flight.getFlightNo());
            preparedStatement.setString(6, flight.getAirline());
            preparedStatement.setString(7, flight.getAirport());

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                showAlert("Success", "Flight has been deleted successfully!", Alert.AlertType.INFORMATION);
                showTable(); // Refresh table
            } else {
                showAlert("Error", "Failed to delete the flight. Please try again.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
