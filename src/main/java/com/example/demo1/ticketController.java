package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ticketController implements Initializable {

    // Labels for customer details
    @FXML
    private Label idreviewdetails, idnameLa, idgmaillLa, idpassLa, idnidLa, idticket, idticket1;

    // TextFields for editing customer details
    @FXML
    private TextField idtxtname, idtxtgmail, idtxtpass, idtxtnid;

    // Labels for flight details
    @FXML
    private Label idfrom, idto, idairname, iddate1, idtime1, idlaseat, idFliname1, idflino1, idseat1;

    // Buttons
    @FXML
    private Button idBack;

    // VBox and StackPane for visibility control


    /**
     * Handles the "Confirm" action for booking confirmation and navigating to the homepage.
     */
    @FXML
    private void confirm2() {
        System.out.println("Total price: " + customer.cprice);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            // Close the current window
            Stage currentStage = (Stage) idBack.getScene().getWindow();
            currentStage.close();

            // Open the new homepage window
            Stage newStage = new Stage();
            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Homepage loaded successfully after confirmation.");
    }

    /**
     * Initializes the controller and sets up default values for the UI elements.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate labels with customer details
        idnameLa.setText(customer.cUsername);
        idpassLa.setText(customer.cPass);
        idnidLa.setText(customer.nId);
        idgmaillLa.setText(customer.cEmail);

        // Populate labels with flight details
        idfrom.setText(customer.cDeparture);
        idto.setText(customer.cdestination);
        idairname.setText(customer.cAirport);
        iddate1.setText(customer.cDate);
        idtime1.setText(customer.cTime);
        idFliname1.setText(customer.cFlightname);
        idseat1.setText(customer.updatedTickets);
        idflino1.setText(customer.cFlightno);
        idticket1.setText(String.valueOf(customer.cticketCount));

        System.out.println("TicketController initialized with customer and flight details.");
    }
}
