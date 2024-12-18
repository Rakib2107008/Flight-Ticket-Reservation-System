package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class flights implements Initializable {

    private  String date;
    private  String  c_lass;

    @FXML
    private Label id_hometitle;

    @FXML
    private Button id_btn1;

    @FXML
    private Button id_admin1;

    @FXML
    private Button btn_logout1;
@FXML
private Button idPre;
    @FXML
    private Label Title;
    @FXML
    private VBox currentVox;

    @FXML
    private Label iddep;

    @FXML
    private TextField iddepField;

    @FXML
    private Label iddes;

    @FXML
    private TextField iddesField;

    @FXML
    private Button idbook;

    @FXML
    private TableView<FlightList> idTableview;

    @FXML
    private TableColumn<FlightList, String> IDfli;

    @FXML
    private TableColumn<FlightList, String> idairport;

    @FXML
    private TableColumn<FlightList, String> idfliname;

    @FXML
    private TableColumn<FlightList, String> idtbdep;

    @FXML
    private TableColumn<FlightList, String> idtbdes;

    @FXML
    private TableColumn<FlightList, String> idtbdate;

    @FXML
    private TableColumn<FlightList, String> idtbtime;

    @FXML
    private TableColumn<FlightList, String> idtbprice;

    @FXML
    private Button idNext;

    @FXML
    private void Home(ActionEvent event) {
        System.out.println("Home button clicked");
        // Add logic for navigating to the home page
        id_btn1.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("homepage.fxml"));
                root=loader.load();
                // flights flightController=loader.getController();
                //  flightController.setIdTicket(idp,availableSeat);
                Stage stage = (Stage)id_btn1.getScene().getWindow();
                stage.close();
                stage = new Stage();

                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("next  clicked");
    }

    @FXML
    private void Admin(ActionEvent event) {
        System.out.println("Admin button clicked");

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
        System.out.println("next  clicked");
    }

    @FXML
    private void Logout(ActionEvent event) {
        System.out.println("Logout button clicked");
         stage = (Stage) btn_logout1.getScene().getWindow();
        stage.close();
        // Add logic for logging out the user
    }

    @FXML
    private void book(ActionEvent event) {
        String departure = iddepField.getText();
        String destination = iddesField.getText();
        FlightList flight = idTableview.getSelectionModel().getSelectedItem();
        int num = idTableview.getSelectionModel().getSelectedIndex();
        if (num - 1 < -1) {
            return;
        }

        int idp= flight.getId();
        customer.idc=idp;
        String flightNo = flight.getFlightNo();
        customer.cFlightno=flightNo;

        String flightName = flight.getAirline();
        customer.cFlightname=flightName;
        String fromCity = flight.getDeparture();
        customer.cDeparture=fromCity;
        String toCity = flight.getDestination();
        customer.cdestination=toCity;
        String date = flight.getDate();
        customer.cDate=date;
        String time = flight.getTime();
        customer.cTime=time;
        String airport = flight.getAirport();
        customer.cAirport=airport;
        int availableSeat= flight.getAvailableTicket();
        customer.cAvailableseats=availableSeat;
        System.out.println(customer.cAvailableseats+"fsfr ");
        String bookedSeat=flight.getBookedTicket();
        customer.cbookedTickets=bookedSeat;
        if((customer.cClass).equals("Economy")){
            customer.cprice=flight.getEconomy();
        }
        else if((customer.cClass).equals("Business")){
            customer.cprice=flight.getBussiness();
        }
        else if((customer.cClass).equals("FirstClass")){
            customer.cprice=flight.getFirstClass();
        }

        idbook.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("seatbook.fxml"));
                root=loader.load();
               // seatController seatControl=loader.getController();
              //  seatControl.setIdTicket(idp,flightNo,flightName,fromCity,toCity,date,time,airport,availableSeat,bookedSeat,c_lass);
                stage = (Stage)idbook.getScene().getWindow();
                stage.close();
                stage = new Stage();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("next  clicked");
        if (departure.isEmpty() || destination.isEmpty()) {
            System.out.println("Please fill in both fields.");
        } else {
            System.out.println("Booking flight from " + departure + " to " + destination);
        }
    }

    @FXML
    private void previousbtn(ActionEvent event) {
        System.out.println("Previous button clicked");
        // Add logic for navigating to the previous page

        idPre.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("homepage.fxml"));
                root=loader.load();
                // flights flightController=loader.getController();
                //  flightController.setIdTicket(idp,availableSeat);
               stage = (Stage)idPre.getScene().getWindow();
               stage.close();
              Stage  stage = new Stage();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("next  clicked");
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private void nextbtn(ActionEvent event) {
        System.out.println("Next button clicked");
        FlightList flight = idTableview.getSelectionModel().getSelectedItem();
        int num = idTableview.getSelectionModel().getSelectedIndex();
        if (num - 1 < -1) {
            return;
        }

        int idp= flight.getId();
        customer.idc=idp;
        String flightNo = flight.getFlightNo();
        customer.cFlightno=flightNo;

        String flightName = flight.getAirline();
        customer.cFlightname=flightName;
        String fromCity = flight.getDeparture();
        customer.cDeparture=fromCity;
        String toCity = flight.getDestination();
        customer.cdestination=toCity;
        String date = flight.getDate();
        customer.cDate=date;
        String time = flight.getTime();
        customer.cTime=time;
        String airport = flight.getAirport();
        customer.cAirport=airport;
        int availableSeat= flight.getAvailableTicket();
        customer.cAvailableseats=availableSeat;
        String bookedSeat=flight.getBookedTicket();
        customer.cbookedTickets=bookedSeat;
        idNext.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("seatbook.fxml"));
                root=loader.load();
                //seatController seat=loader.getController();


              //  seat.setIdTicket(idp,flightNo,flightName,fromCity,toCity,date,time,airport,availableSeat,bookedSeat,c_lass);
                stage = (Stage)idNext.getScene().getWindow();
                stage.close();
               stage = new Stage();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("next  clicked");
        //showTable();
        // Add logic for navigating to the next page
    }

//    public void setDestination(String departure, String destination, String c_lass, String date) {
//        iddepField.setText(departure);
//        iddesField.setText(destination);
//        this.date = date;
//        this.c_lass = c_lass;
//    }

    public ObservableList<FlightList> flightList() {
        ObservableList<FlightList> flightL = FXCollections.observableArrayList();
        Connection connectDB = DatabaseConnection.databaseLink;

        String query = "SELECT * FROM Flight_list";

        try (
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(query)
        ) {
            while (queryResult.next()) {
                if ("No Date Selected".equals(date)) {
                if (queryResult.getString("desti").equals(iddesField.getText()) &&
                            queryResult.getString("Source").equals(iddepField.getText())) {
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
                                queryResult.getDouble("Bussiness($)")
                                , queryResult.getInt("AvailableTicket") ,
                                queryResult.getString("Bokkedseat")
                        );
                    System.out.println("le,jfmhngklj,e");
                    System.out.println(flight.getTime()+" "+flight.getDate());
                    if(isDateValid(flight.getDate(),flight.getTime()) && flight.getAvailableTicket()>0)
                    {   System.out.println("Tonyam");
                        System.out.println(flight.getTime()+" "+flight.getDate());
                        System.out.println(flight.getAvailableTicket());
                        flightL.add(flight);}

                   // flightL.add(flight);
                    }
                 } else {
                    if (queryResult.getString("desti").equals(iddesField.getText()) &&
                            queryResult.getString("Source").equals(iddepField.getText()) &&
                            queryResult.getString("date").equals(date)) {
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
                                queryResult.getDouble("Bussiness($)")
                                , queryResult.getInt("AvailableTicket"),
                                queryResult.getString("Bokkedseat")
                        );
                        System.out.println("le,jfmhngklj,e");
                        System.out.println(flight.getTime()+" "+flight.getDate());
                        if(isDateValid(flight.getDate(),flight.getTime()) && flight.getAvailableTicket()>0)
                        {   System.out.println("Tonyam");
                            System.out.println(flight.getTime()+" "+flight.getDate());
                            System.out.println(flight.getAvailableTicket());
                            flightL.add(flight);}
                    }
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flightL;
    }

    private ObservableList<FlightList> flights;

    void showTable() {
        flights = flightList();

        idtbdep.setCellValueFactory(new PropertyValueFactory<>("departure"));
        idtbdes.setCellValueFactory(new PropertyValueFactory<>("destination"));
        IDfli.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
        idfliname.setCellValueFactory(new PropertyValueFactory<>("airline"));
        idtbdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        idtbtime.setCellValueFactory(new PropertyValueFactory<>("time"));
        idairport.setCellValueFactory(new PropertyValueFactory<>("airport"));


        if(c_lass.equals("Economy")){
            idtbprice.setCellValueFactory(new PropertyValueFactory<>("Economy"));

        }
        else if(c_lass.equals("Business")){
            idtbprice.setCellValueFactory(new PropertyValueFactory<>("Bussiness"));
        }
        else if(c_lass.equals("FirstClass")){
            idtbprice.setCellValueFactory(new PropertyValueFactory<>("FirstClass"));
        }
        idTableview.setItems(flights);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iddepField.setText(customer.cDeparture);
        iddesField.setText(customer.cdestination);
       this.date =customer.cDate;
      this.c_lass = customer.cClass;
        System.out.println("FlightList controller initialized.");
        //setDestination(departure,destination,c_la);
        showTable();


    }
    public static boolean isDateValid(String userInputDate, String userInputTime) {
        try {
            // Parse the input strings to LocalDate and LocalTime
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Convert the user input to LocalDate and LocalTime
            LocalDate flightDate = LocalDate.parse(userInputDate, dateFormatter);
            LocalTime flightTime = LocalTime.parse(userInputTime, timeFormatter);

            // Combine LocalDate and LocalTime into LocalDateTime
            LocalDateTime departureDateTime = LocalDateTime.of(flightDate, flightTime);

            // Get current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Calculate the time difference between current time and departure time
            Duration duration = Duration.between(currentDateTime, departureDateTime);

            // If the departure time is in the future (greater than 24 hours), return true
            return duration.toSeconds() > 0;

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date or time format. Please ensure your date is in 'yyyy-MM-dd' format and time in 'HH:mm:ss' format.");
            return false; // Return false if there's an error parsing the date or time
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
