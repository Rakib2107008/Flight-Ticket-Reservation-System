package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class confirmController implements Initializable {

    // ImageView and Labels
    @FXML
    private ImageView idreview;

    @FXML
    private Label idreviewdetails, idname, idnameLa, idgmail, idgmaillLa, idpass, idpassLa,
            idnid, idnidLa, idfrom, idto, idairname, idlaDate, idlaTime, idlaseat, idlaFlight;

    // Editable Fields (TextFields)
    @FXML
    private TextField idtxtname, idtxtgmail, idtxtpass, idtxtnid;

    // Buttons
    @FXML
    private Button idedit, idconfirm, idconfirm2;

    // Layouts
    @FXML
    private VBox vbox1, vbox2;

    @FXML
    private HBox hbox1, hbox2;

    @FXML
    private Label idunable;

    /**
     * Handles the "Edit" action to switch the UI to edit mode.
     */
    @FXML
    private void idedit() {
        // Switch to edit mode
        vbox1.setVisible(false);
        vbox2.setVisible(true);
        hbox1.setVisible(false);
        hbox2.setVisible(true);

        // Populate TextFields with current details
        idtxtname.setText(idnameLa.getText().trim());
        idtxtgmail.setText(idgmaillLa.getText().trim());
        idtxtpass.setText(idpassLa.getText().trim());
        idtxtnid.setText(idnidLa.getText().trim());

    }

    /**
     * Handles the "Confirm" action after reviewing details.
     */
    @FXML
    private void onconfirm() {
        System.out.println(customer.cprice + "kjh");
        SSLCommerz.totalAmount = customer.cprice;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/sslcommerz.fxml"));
            Parent root = loader.load();

            // Close the current stage and open a new one
            Stage stage = (Stage) idconfirm.getScene().getWindow();
            stage.close();

            Stage stage1 = new Stage();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Next clicked");
    }

    /**
     * Handles the "Confirm" action in edit mode to save changes.
     */
    @FXML
    private void confirm2() {
        // Retrieve edited details
        String name = idtxtname.getText().trim();
        String gmail = idtxtgmail.getText().trim();
        String passport = idtxtpass.getText().trim();
        String nid = idtxtnid.getText().trim();

        // Validate inputs
        if (name.isEmpty() || gmail.isEmpty() || passport.isEmpty() || nid.isEmpty()) {
            idunable.setText("All fields must be filled out.");
            return;
        }
        if (!gmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.-]+$")) {
            showAlert("Validation Error", "Invalid email format. Please provide a valid email address.", Alert.AlertType.WARNING);
            return;
        }

        // Update labels with new details
        idnameLa.setText(name);
        idgmaillLa.setText(gmail);
        idpassLa.setText(passport);
        idnidLa.setText(nid);

        customer.cUsername=(idtxtname.getText().trim());
        customer.cEmail=idtxtgmail.getText().trim();
        customer.cPass=idtxtpass.getText().trim();
        customer.nId=idnid.getText().trim();

        // Switch back to view mode
        vbox1.setVisible(true);
        vbox2.setVisible(false);
        hbox1.setVisible(true);
        hbox2.setVisible(false);

        // Display success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Details Updated");
        alert.setHeaderText(null);
        alert.setContentText("Traveler details have been updated successfully.");
        alert.showAndWait();
    }

    /**
     * Initializes the controller with default values and UI state.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set initial visibility of layouts
        vbox1.setVisible(true);
        vbox2.setVisible(false);
        hbox1.setVisible(true);
        hbox2.setVisible(false);

        // Populate labels with customer details
        idnameLa.setText(customer.cUsername);
        idpassLa.setText(customer.cPass);
        idnidLa.setText(customer.nId);
        idgmaillLa.setText(customer.cEmail);
        idfrom.setText(customer.cDeparture);
        idto.setText(customer.cdestination);
        idairname.setText(customer.cAirport);
        idlaDate.setText(customer.cDate);
        idlaTime.setText(customer.cTime);
        idlaFlight.setText(customer.cFlightno);
        idlaseat.setText(customer.updatedTickets);
    }
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
