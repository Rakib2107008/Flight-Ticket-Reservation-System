package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class seatController implements Initializable {
    private int count=0;
   private int idp;
  private  String flightNo;
   private String flightName;
  private  String fromCity;
  private  String toCity;
  private   String date;
 private    String time;
  private   String airport;
    private int  availableSeat;
private  String bookedseat;
private  String c_lass;
    // FXML elements
    @FXML private Label idtitle;
    @FXML private Button idhome;
    @FXML private Button idadmin;
    @FXML private Button idlogout;
    @FXML private Label airname;
    @FXML private Label idcolor;
    @FXML private Label idfclass;
    @FXML private Label idblue;
    @FXML private Label idbclass;
    @FXML private Label idlight;
    @FXML private Label ideco;
@FXML private Label idlight1;
    @FXML private Label ideco1;

    // Seat ToggleButtons
    @FXML private ToggleButton A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23, C24, C25,
            D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12, D13, D14, D15, D16, D17, D18, D19, D20, D21, D22, D23, D24, D25,
            E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15, E16, E17, E18, E19, E20, E21, E22, E23, E24, E25,
            F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20, F21, F22, F23, F24, F25;
            ;

    // Handle home button click
    @FXML
    private VBox vbox1;  // First VBox that contains passenger details (disabled)
    @FXML
    private VBox vbox2;  // Second VBox that contains input fields for user data
    @FXML
    private Button idcancel2;  // Cancel button for vbox1
    @FXML
    private Button idcontinue2; // Continue button for vbox1
    @FXML
    private Button idcancel;  // Cancel button for vbox2
    @FXML
    private Button idcontinue; // Continue button for vbox2

    @FXML
    private TextField idname2;  // Passenger Name (disabled)
    @FXML
    private TextField idname3;  // Another Name field (disabled)
    @FXML
    private TextField idname4;  // Another Name field (disabled)
    @FXML
    private TextField idname5;  // Another Name field (disabled)

    @FXML
    private TextField idtxtuser;  // User Name input field
    @FXML
    private TextField idtxtemail; // Email input field
    @FXML
    private TextField idpassport; // Passport input field
    @FXML
    private TextField idNational; // National ID input field
    public ArrayList<String> List;
    // Method to show the second VBox with the input fields
    public void showPassengerDetails() {
        vbox1.setVisible(false); // Hide the first VBox
        vbox2.setVisible(true);  // Show the second VBox
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private void onhome(ActionEvent event) {
        System.out.println("Home button clicked");
        // Add logic for navigating to the home page
        idhome.setOnMouseClicked(event1 -> {
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
        });
        System.out.println("next  clicked");
    }
    @FXML
    private void onadmin(ActionEvent event) {
        System.out.println("Admin button clicked");

        idadmin.setOnMouseClicked(event1 -> {
            try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("Admin.fxml"));
                root=loader.load();
                // flights flightController=loader.getController();
                //  flightController.setIdTicket(idp,availableSeat);
                stage = (Stage)idadmin.getScene().getWindow();
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
    private void onlogout(ActionEvent event) {
        System.out.println("Logout button clicked");
        stage = (Stage) idlogout.getScene().getWindow();
        stage.close();
        // Add logic for logging out the user
    }
    // Method to handle cancel button for the first VBox (idcancel2)
    @FXML
    private void cancel2() {
        // Hide the second VBox and show the first VBox again
      //  vbox2.setVisible(false);
      //  vbox1.setVisible(true);
        System.out.println("cancel 2 clicked");
    }

    // Method to handle cancel button for the second VBox (idcancel)
    @FXML
    private void cancel() {
        // Reset the fields (you may want to add custom logic for resetting values)
        idtxtuser.clear();
        idtxtemail.clear();
        idpassport.clear();
        idNational.clear();

        // Hide the second VBox and show the first VBox again
      //  vbox2.setVisible(false);
       // vbox1.setVisible(true);
    }

    // Method to handle continue button for the first VBox (idcontinue2)
    @FXML
    private void continue2() {
        // Perform your action when continue is clicked (like moving to the next screen or validating inputs)
        System.out.println("Continuing with passenger details...");
    }

    // Method to handle continue button for the second VBox (idcontinue)
    @FXML
    private void oncontinue(ActionEvent event) {
        List=new ArrayList<>();
int ticket_count=0;
if(A1.isSelected()) {
ticket_count++;
String s=A1.getId();
List.add(s);
}
if(A2.isSelected()) {
    ticket_count++;
    String s=A2.getId();
    List.add(s);
}
if(A3.isSelected()) {
    ticket_count++;
    String s=A3.getId();
    List.add(s);

}
if(A4.isSelected()) {
    ticket_count++;
    String s=A4.getId();
    List.add(s);
}
        if (A4.isSelected()) {
            ticket_count++;
            String s = A4.getId();
            List.add(s);
        }
        if (A5.isSelected()) {
            ticket_count++;
            String s = A5.getId();
            List.add(s);
        }
        if (A6.isSelected()) {
            ticket_count++;
            String s = A6.getId();
            List.add(s);
        }
        if (A7.isSelected()) {
            ticket_count++;
            String s = A7.getId();
            List.add(s);
        }
        if (A8.isSelected()) {
            ticket_count++;
            String s = A8.getId();
            List.add(s);
        }
        if (A9.isSelected()) {
            ticket_count++;
            String s = A9.getId();
            List.add(s);
        }
        if (A10.isSelected()) {
            ticket_count++;
            String s = A10.getId();
            List.add(s);
        }
        if (A11.isSelected()) {
            ticket_count++;
            String s = A11.getId();
            List.add(s);
        }
        if (A12.isSelected()) {
            ticket_count++;
            String s = A12.getId();
            List.add(s);
        }
        if (A13.isSelected()) {
            ticket_count++;
            String s = A13.getId();
            List.add(s);
        }
        if (A14.isSelected()) {
            ticket_count++;
            String s = A14.getId();
            List.add(s);
        }
        if (A15.isSelected()) {
            ticket_count++;
            String s = A15.getId();
            List.add(s);
        }
        if (A16.isSelected()) {
            ticket_count++;
            String s = A16.getId();
            List.add(s);
        }
        if (A17.isSelected()) {
            ticket_count++;
            String s = A17.getId();
            List.add(s);
        }
        if (A18.isSelected()) {
            ticket_count++;
            String s = A18.getId();
            List.add(s);
        }
        if (A19.isSelected()) {
            ticket_count++;
            String s = A19.getId();
            List.add(s);
        }
        if (A20.isSelected()) {
            ticket_count++;
            String s = A20.getId();
            List.add(s);
        }
        if (A21.isSelected()) {
            ticket_count++;
            String s = A21.getId();
            List.add(s);
        }
        if (A22.isSelected()) {
            ticket_count++;
            String s = A22.getId();
            List.add(s);
        }
        if (A23.isSelected()) {
            ticket_count++;
            String s = A23.getId();
            List.add(s);
        }
        if (A24.isSelected()) {
            ticket_count++;
            String s = A24.getId();
            List.add(s);
        }
        if (A25.isSelected()) {
            ticket_count++;
            String s = A25.getId();
            List.add(s);
        }
        // For B
        if(B1.isSelected()) {
            ticket_count++;
            String s = B1.getId();
            List.add(s);
        }
        if(B2.isSelected()) {
            ticket_count++;
            String s = B2.getId();
            List.add(s);
        }
        if(B3.isSelected()) {
            ticket_count++;
            String s = B3.getId();
            List.add(s);
        }
        if(B4.isSelected()) {
            ticket_count++;
            String s = B4.getId();
            List.add(s);
        }
        if(B5.isSelected()) {
            ticket_count++;
            String s = B5.getId();
            List.add(s);
        }
        if(B6.isSelected()) {
            ticket_count++;
            String s = B6.getId();
            List.add(s);
        }
        if(B7.isSelected()) {
            ticket_count++;
            String s = B7.getId();
            List.add(s);
        }
        if(B8.isSelected()) {
            ticket_count++;
            String s = B8.getId();
            List.add(s);
        }
        if(B9.isSelected()) {
            ticket_count++;
            String s = B9.getId();
            List.add(s);
        }
        if(B10.isSelected()) {
            ticket_count++;
            String s = B10.getId();
            List.add(s);
        }
        if(B11.isSelected()) {
            ticket_count++;
            String s = B11.getId();
            List.add(s);
        }
        if(B12.isSelected()) {
            ticket_count++;
            String s = B12.getId();
            List.add(s);
        }
        if(B13.isSelected()) {
            ticket_count++;
            String s = B13.getId();
            List.add(s);
        }
        if(B14.isSelected()) {
            ticket_count++;
            String s = B14.getId();
            List.add(s);
        }
        if(B15.isSelected()) {
            ticket_count++;
            String s = B15.getId();
            List.add(s);
        }
        if(B16.isSelected()) {
            ticket_count++;
            String s = B16.getId();
            List.add(s);
        }
        if(B17.isSelected()) {
            ticket_count++;
            String s = B17.getId();
            List.add(s);
        }
        if(B18.isSelected()) {
            ticket_count++;
            String s = B18.getId();
            List.add(s);
        }
        if(B19.isSelected()) {
            ticket_count++;
            String s = B19.getId();
            List.add(s);
        }
        if(B20.isSelected()) {
            ticket_count++;
            String s = B20.getId();
            List.add(s);
        }
        if(B21.isSelected()) {
            ticket_count++;
            String s = B21.getId();
            List.add(s);
        }
        if(B22.isSelected()) {
            ticket_count++;
            String s = B22.getId();
            List.add(s);
        }
        if(B23.isSelected()) {
            ticket_count++;
            String s = B23.getId();
            List.add(s);
        }
        if(B24.isSelected()) {
            ticket_count++;
            String s = B24.getId();
            List.add(s);
        }
        if(B25.isSelected()) {
            ticket_count++;
            String s = B25.getId();
            List.add(s);}
        if(C1.isSelected()) {
            ticket_count++;
            String s = C1.getId();
            List.add(s);
        }
        if(C2.isSelected()) {
            ticket_count++;
            String s = C2.getId();
            List.add(s);
        }
        if(C3.isSelected()) {
            ticket_count++;
            String s = C3.getId();
            List.add(s);
        }
        if(C4.isSelected()) {
            ticket_count++;
            String s = C4.getId();
            List.add(s);
        }
        if(C5.isSelected()) {
            ticket_count++;
            String s = C5.getId();
            List.add(s);
        }
        if(C6.isSelected()) {
            ticket_count++;
            String s = C6.getId();
            List.add(s);
        }
        if(C7.isSelected()) {
            ticket_count++;
            String s = C7.getId();
            List.add(s);
        }
        if(C8.isSelected()) {
            ticket_count++;
            String s = C8.getId();
            List.add(s);
        }
        if(C9.isSelected()) {
            ticket_count++;
            String s = C9.getId();
            List.add(s);
        }
        if(C10.isSelected()) {
            ticket_count++;
            String s = C10.getId();
            List.add(s);
        }
        if(C11.isSelected()) {
            ticket_count++;
            String s = C11.getId();
            List.add(s);
        }
        if(C12.isSelected()) {
            ticket_count++;
            String s = C12.getId();
            List.add(s);
        }
        if(C13.isSelected()) {
            ticket_count++;
            String s = C13.getId();
            List.add(s);
        }
        if(C14.isSelected()) {
            ticket_count++;
            String s = C14.getId();
            List.add(s);
        }
        if(C15.isSelected()) {
            ticket_count++;
            String s = C15.getId();
            List.add(s);
        }
        if(C16.isSelected()) {
            ticket_count++;
            String s = C16.getId();
            List.add(s);
        }
        if(C17.isSelected()) {
            ticket_count++;
            String s = C17.getId();
            List.add(s);
        }
        if(C18.isSelected()) {
            ticket_count++;
            String s = C18.getId();
            List.add(s);
        }
        if(C19.isSelected()) {
            ticket_count++;
            String s = C19.getId();
            List.add(s);
        }
        if(C20.isSelected()) {
            ticket_count++;
            String s = C20.getId();
            List.add(s);
        }
        if(C21.isSelected()) {
            ticket_count++;
            String s = C21.getId();
            List.add(s);
        }
        if(C22.isSelected()) {
            ticket_count++;
            String s = C22.getId();
            List.add(s);
        }
        if(C23.isSelected()) {
            ticket_count++;
            String s = C23.getId();
            List.add(s);
        }
        if(C24.isSelected()) {
            ticket_count++;
            String s = C24.getId();
            List.add(s);
        }
        if(C25.isSelected()) {
            ticket_count++;
            String s = C25.getId();
            List.add(s);
        }

        if(D1.isSelected()) {
            ticket_count++;
            String s = D1.getId();
            List.add(s);
        }
        if(D2.isSelected()) {
            ticket_count++;
            String s = D2.getId();
            List.add(s);
        }
        if(D3.isSelected()) {
            ticket_count++;
            String s = D3.getId();
            List.add(s);
        }
        if(D4.isSelected()) {
            ticket_count++;
            String s = D4.getId();
            List.add(s);
        }
        if(D5.isSelected()) {
            ticket_count++;
            String s = D5.getId();
            List.add(s);
        }
        if(D6.isSelected()) {
            ticket_count++;
            String s = D6.getId();
            List.add(s);
        }
        if(D7.isSelected()) {
            ticket_count++;
            String s = D7.getId();
            List.add(s);
        }
        if(D8.isSelected()) {
            ticket_count++;
            String s = D8.getId();
            List.add(s);
        }
        if(D9.isSelected()) {
            ticket_count++;
            String s = D9.getId();
            List.add(s);
        }
        if(D10.isSelected()) {
            ticket_count++;
            String s = D10.getId();
            List.add(s);
        }
        if(D11.isSelected()) {
            ticket_count++;
            String s = D11.getId();
            List.add(s);
        }
        if(D12.isSelected()) {
            ticket_count++;
            String s = D12.getId();
            List.add(s);
        }
        if(D13.isSelected()) {
            ticket_count++;
            String s = D13.getId();
            List.add(s);
        }
        if(D14.isSelected()) {
            ticket_count++;
            String s = D14.getId();
            List.add(s);
        }
        if(D15.isSelected()) {
            ticket_count++;
            String s = D15.getId();
            List.add(s);
        }
        if(D16.isSelected()) {
            ticket_count++;
            String s = D16.getId();
            List.add(s);
        }
        if(D17.isSelected()) {
            ticket_count++;
            String s = D17.getId();
            List.add(s);
        }
        if(D18.isSelected()) {
            ticket_count++;
            String s = D18.getId();
            List.add(s);
        }
        if(D19.isSelected()) {
            ticket_count++;
            String s = D19.getId();
            List.add(s);
        }
        if(D20.isSelected()) {
            ticket_count++;
            String s = D20.getId();
            List.add(s);
        }
        if(D21.isSelected()) {
            ticket_count++;
            String s = D21.getId();
            List.add(s);
        }
        if(D22.isSelected()) {
            ticket_count++;
            String s = D22.getId();
            List.add(s);
        }
        if(D23.isSelected()) {
            ticket_count++;
            String s = D23.getId();
            List.add(s);
        }
        if(D24.isSelected()) {
            ticket_count++;
            String s = D24.getId();
            List.add(s);
        }
        if(D25.isSelected()) {
            ticket_count++;
            String s = D25.getId();
            List.add(s);
        }

        if(E1.isSelected()) {
            ticket_count++;
            String s = E1.getId();
            List.add(s);
        }
        if(E2.isSelected()) {
            ticket_count++;
            String s = E2.getId();
            List.add(s);
        }
        if(E3.isSelected()) {
            ticket_count++;
            String s = E3.getId();
            List.add(s);
        }
        if(E4.isSelected()) {
            ticket_count++;
            String s = E4.getId();
            List.add(s);
        }
        if(E5.isSelected()) {
            ticket_count++;
            String s = E5.getId();
            List.add(s);
        }
        if(E6.isSelected()) {
            ticket_count++;
            String s = E6.getId();
            List.add(s);
        }
        if(E7.isSelected()) {
            ticket_count++;
            String s = E7.getId();
            List.add(s);
        }
        if(E8.isSelected()) {
            ticket_count++;
            String s = E8.getId();
            List.add(s);
        }
        if(E9.isSelected()) {
            ticket_count++;
            String s = E9.getId();
            List.add(s);
        }
        if(E10.isSelected()) {
            ticket_count++;
            String s = E10.getId();
            List.add(s);
        }
        if(E11.isSelected()) {
            ticket_count++;
            String s = E11.getId();
            List.add(s);
        }
        if(E12.isSelected()) {
            ticket_count++;
            String s = E12.getId();
            List.add(s);
        }
        if(E13.isSelected()) {
            ticket_count++;
            String s = E13.getId();
            List.add(s);
        }
        if(E14.isSelected()) {
            ticket_count++;
            String s = E14.getId();
            List.add(s);
        }
        if(E15.isSelected()) {
            ticket_count++;
            String s = E15.getId();
            List.add(s);
        }
        if(E16.isSelected()) {
            ticket_count++;
            String s = E16.getId();
            List.add(s);
        }
        if(E17.isSelected()) {
            ticket_count++;
            String s = E17.getId();
            List.add(s);
        }
        if(E18.isSelected()) {
            ticket_count++;
            String s = E18.getId();
            List.add(s);
        }
        if(E19.isSelected()) {
            ticket_count++;
            String s = E19.getId();
            List.add(s);
        }
        if(E20.isSelected()) {
            ticket_count++;
            String s = E20.getId();
            List.add(s);
        }
        if(E21.isSelected()) {
            ticket_count++;
            String s = E21.getId();
            List.add(s);
        }
        if(E22.isSelected()) {
            ticket_count++;
            String s = E22.getId();
            List.add(s);
        }
        if(E23.isSelected()) {
            ticket_count++;
            String s = E23.getId();
            List.add(s);
        }
        if(E24.isSelected()) {
            ticket_count++;
            String s = E24.getId();
            List.add(s);
        }
        if(E25.isSelected()) {
            ticket_count++;
            String s = E25.getId();
            List.add(s);
        }
        if(F1.isSelected()) {
            ticket_count++;
            String s = F1.getId();
            List.add(s);
        }
        if(F2.isSelected()) {
            ticket_count++;
            String s = F2.getId();
            List.add(s);
        }
        if(F3.isSelected()) {
            ticket_count++;
            String s = F3.getId();
            List.add(s);
        }
        if(F4.isSelected()) {
            ticket_count++;
            String s = F4.getId();
            List.add(s);
        }
        if(F5.isSelected()) {
            ticket_count++;
            String s = F5.getId();
            List.add(s);
        }
        if(F6.isSelected()) {
            ticket_count++;
            String s = F6.getId();
            List.add(s);
        }
        if(F7.isSelected()) {
            ticket_count++;
            String s = F7.getId();
            List.add(s);
        }
        if(F8.isSelected()) {
            ticket_count++;
            String s = F8.getId();
            List.add(s);
        }
        if(F9.isSelected()) {
            ticket_count++;
            String s = F9.getId();
            List.add(s);
        }
        if(F10.isSelected()) {
            ticket_count++;
            String s = F10.getId();
            List.add(s);
        }
        if(F11.isSelected()) {
            ticket_count++;
            String s = F11.getId();
            List.add(s);
        }
        if(F12.isSelected()) {
            ticket_count++;
            String s = F12.getId();
            List.add(s);
        }
        if(F13.isSelected()) {
            ticket_count++;
            String s = F13.getId();
            List.add(s);
        }
        if(F14.isSelected()) {
            ticket_count++;
            String s = F14.getId();
            List.add(s);
        }
        if(F15.isSelected()) {
            ticket_count++;
            String s = F15.getId();
            List.add(s);
        }
        if(F16.isSelected()) {
            ticket_count++;
            String s = F16.getId();
            List.add(s);
        }
        if(F17.isSelected()) {
            ticket_count++;
            String s = F17.getId();
            List.add(s);
        }
        if(F18.isSelected()) {
            ticket_count++;
            String s = F18.getId();
            List.add(s);
        }
        if(F19.isSelected()) {
            ticket_count++;
            String s = F19.getId();
            List.add(s);
        }
        if(F20.isSelected()) {
            ticket_count++;
            String s = F20.getId();
            List.add(s);
        }
        if(F21.isSelected()) {
            ticket_count++;
            String s = F21.getId();
            List.add(s);
        }
        if(F22.isSelected()) {
            ticket_count++;
            String s = F22.getId();
            List.add(s);
        }
        if(F23.isSelected()) {
            ticket_count++;
            String s = F23.getId();
            List.add(s);
        }
        if(F24.isSelected()) {
            ticket_count++;
            String s = F24.getId();
            List.add(s);
        }
        if(F25.isSelected()) {
            ticket_count++;
            String s = F25.getId();
            List.add(s);
        }


        if (ticket_count > 0) {
            if (isValidInput()) {
                System.out.println("User data valid, proceeding...");


                // Retrieve and assign user details
                String user = idtxtuser.getText().trim();
                customer.cUsername = user;

                String email = idtxtemail.getText().trim();
                customer.cEmail = email;

                String passport = idpassport.getText().trim();
                customer.cPass = passport;

                String national = idNational.getText().trim();
                customer.nId = national;
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.-]+$")) {
                    showAlert("Validation Error", "Invalid email format. Please provide a valid email address.", Alert.AlertType.WARNING);
                    return;
                }

                // Update ticket and pricing details
                String updatedTickets;
                customer.cticketCount = List.size();
                customer.cprice = (customer.cprice * customer.cticketCount);

                if (List.size() == 1) {
                    updatedTickets = List.get(0);
                } else {
                    updatedTickets = String.join(",", List);
                }
                customer.updatedTickets = updatedTickets;

                // Log the updated information
                System.out.println(updatedTickets + " " + bookedseat);
                System.out.println(customer.cticketCount + " " + customer.cAvailableseats);

                // Set click event for "Continue" button
                idcontinue.setOnMouseClicked(event1 -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirm.fxml"));
                        Parent root = loader.load();

                        // Uncomment and implement if needed
                        // confirmController seat = loader.getController();
                        // seat.setIdTicket(idp, flightNo, flightName, fromCity, toCity, date, time,
                        // airport, availableSeat, bookedseat, c_lass, updatedTickets, user, email,
                        // passport, national);

                        Stage stage = (Stage) idcontinue.getScene().getWindow();
                        stage.close();
                        stage=new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                System.out.println("Next clicked");
            } else {
                showAlert("Validation Error", "Invalid email format. Please provide a valid Gmail address.", Alert.AlertType.WARNING);
                return;
            }
        }}

// Method to validate user input
        private boolean isValidInput() {
            // Validate that fields are not empty
            return !idtxtuser.getText().isEmpty() &&
                    !idtxtemail.getText().isEmpty() &&
                    !idpassport.getText().isEmpty() &&
                    !idNational.getText().isEmpty();
        }

        @FXML
    private void handleHomeButtonClick(ActionEvent event) {
        System.out.println("Home button clicked!");
        // Navigate to the home page or reset fields
    }

    // Handle admin button click
    @FXML
    private void handleAdminButtonClick(ActionEvent event) {
        System.out.println("Admin button clicked!");
        // Open admin-related view
    }

    // Handle logout button click
    @FXML
    private void handleLogoutButtonClick(ActionEvent event) {
        System.out.println("Logout button clicked!");
        // Logout logic here, e.g., navigating back to the login page
    }

    // Handle seat toggle button click (example for A1)
    @FXML
    private void handleSeatToggle(ActionEvent event) {
        ToggleButton clickedButton = (ToggleButton) event.getSource();

        if (clickedButton.isSelected()) {
            System.out.println(clickedButton.getText() + " is selected.");
            // You can add logic to update seat availability in a database or model
        } else {
            System.out.println(clickedButton.getText() + " is deselected.");
            // You can update seat availability when deselected
        }
    }

    // Initialize method for setting up initial behavior
//    @FXML
//    private void initialize() {
//        // Set up initial states for seats (example: A1 to A25 as available)
//
//    }

    // Initialize all seat toggle buttons
//    private void initializeSeats() {
//        A1.setSelected(false);
//        A2.setSelected(false);
//        A3.setSelected(false);
//        A4.setSelected(false);
//        A5.setSelected(false);
//        A6.setSelected(false);
//        A7.setSelected(false);
//        A8.setSelected(false);
//        A9.setSelected(false);
//        A10.setSelected(false);
//        A11.setSelected(false);
//        A12.setSelected(false);
//        A13.setSelected(false);
//        A14.setSelected(false);
//        A15.setSelected(false);
//        A16.setSelected(false);
//        A17.setSelected(false);
//        A18.setSelected(false);
//        A19.setSelected(false);
//        A20.setSelected(false);
//        A21.setSelected(false);
//        A22.setSelected(false);
//        A23.setSelected(false);
//        A24.setSelected(false);
//        A25.setSelected(false);
//    }
public void setIdTicket() {
    this.idp = customer.idc;
    this.flightNo = customer.cFlightno;
    this.flightName =customer.cFlightname ;
    this.fromCity = customer.cDeparture;
    this.toCity = customer.cdestination;
    this.date =customer.cDate;
    this.time = customer.cTime;
    this.airport = customer.cAirport   ;
    this.availableSeat = customer.cAvailableseats;
    this.bookedseat = customer.cbookedTickets;
    this.c_lass = customer.cClass;

    ArrayList<String> arrayList = new ArrayList<>();
    if(bookedseat!=null){
    String[] elements = bookedseat.split(",");

    // Add all non-empty elements to the ArrayList
    arrayList.addAll(Arrays.asList(elements));}
    // Access elements using a for-each loop

    if (c_lass.equals("Economy")) {
        if(arrayList.size()!=0)
        {for (String seat : arrayList) {
          if(seat.equals("A10")) {
              A10.setDisable(true);
              A10.setStyle("-fx-background-color: coral");
          }
            if (seat.equals("A11")) {
                A11.setDisable(true);
                A11.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A12")) {
                A12.setDisable(true);
                A12.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A13")) {
                A13.setDisable(true);
                A13.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A14")) {
                A14.setDisable(true);
                A14.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A15")) {
                A15.setDisable(true);
                A15.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A16")) {
                A16.setDisable(true);
                A16.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A17")) {
                A17.setDisable(true);
                A17.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A18")) {
                A18.setDisable(true);
                A18.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A19")) {
                A19.setDisable(true);
                A19.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A20")) {
                A20.setDisable(true);
                A20.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A21")) {
                A21.setDisable(true);
                A21.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A22")) {
                A22.setDisable(true);
                A22.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A23")) {
                A23.setDisable(true);
                A23.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A24")) {
                A24.setDisable(true);
                A24.setStyle("-fx-background-color: coral");
            }
            else if (seat.equals("A25")) {
                A25.setDisable(true);
                A25.setStyle("-fx-background-color: coral");
            }

            else if(seat.equals("B10")) {
                B10.setDisable(true);
                B10.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B11")) {
                B11.setDisable(true);
                B11.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B12")) {
                B12.setDisable(true);
                B12.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B13")) {
                B13.setDisable(true);
                B13.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B14")) {
                B14.setDisable(true);
                B14.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B15")) {
                B15.setDisable(true);
                B15.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B16")) {
                B16.setDisable(true);
                B16.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B17")) {
                B17.setDisable(true);
                B17.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B18")) {
                B18.setDisable(true);
                B18.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B19")) {
                B19.setDisable(true);
                B19.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B20")) {
                B20.setDisable(true);
                B20.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B21")) {
                B21.setDisable(true);
                B21.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B22")) {
                B22.setDisable(true);
                B22.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B23")) {
                B23.setDisable(true);
                B23.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B24")) {
                B24.setDisable(true);
                B24.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B25")) {
                B25.setDisable(true);
                    B24.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C10")) {
                C10.setDisable(true);
                C10.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C11")) {
                C11.setDisable(true);
                C11.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C12")) {
                C12.setDisable(true);
                C12.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C13")) {
                C13.setDisable(true);
                C13.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C14")) {
                C14.setDisable(true);
                C14.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C15")) {
                C15.setDisable(true);
                C15.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C16")) {
                C16.setDisable(true);
                C16.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C17")) {
                C17.setDisable(true);
                C17.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C18")) {
                C18.setDisable(true);
                C18.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C19")) {
                C19.setDisable(true);
                C19.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C20")) {
                C20.setDisable(true);
                C20.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C21")) {
                C21.setDisable(true);
                C21.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C22")) {
                C22.setDisable(true);
                C22.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C23")) {
                C23.setDisable(true);
                C23.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C24")) {
                C24.setDisable(true);
                C24.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C25")) {
                C25.setDisable(true);
                C25.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D10")) {
                D10.setDisable(true);
                    D10.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D11")) {
                D11.setDisable(true);
                D11.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D12")) {
                D12.setDisable(true);
                D12.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D13")) {
                D13.setDisable(true);
                D13.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D14")) {
                D14.setDisable(true);
                D14.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D15")) {
                D15.setDisable(true);
                D15.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D16")) {
                D16.setDisable(true);
                D16.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D17")) {
                D17.setDisable(true);
                D17.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D18")) {
                D18.setDisable(true);
                D18.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D19")) {
                D19.setDisable(true);
                D19.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D20")) {
                D20.setDisable(true);
                D20.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D21")) {
                D21.setDisable(true);
                D21.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D22")) {
                D22.setDisable(true);
                D22.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D23")) {
                D23.setDisable(true);
                D23.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D24")) {
                D24.setDisable(true);
                D24.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D25")) {
                D25.setDisable(true);
                D25.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E10")) {
                E10.setDisable(true);
                E10.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E11")) {
                E11.setDisable(true);
                E11.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E12")) {
                E12.setDisable(true);
                E12.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E13")) {
                E13.setDisable(true);
                E13.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E14")) {
                E14.setDisable(true);
                E14.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E15")) {
                E15.setDisable(true);
                E15.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E16")) {
                E16.setDisable(true);
                E16.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E17")) {
                E17.setDisable(true);
                    E17.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E18")) {
                E18.setDisable(true);
                E18.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E19")) {
                E19.setDisable(true);
                E19.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E20")) {
                E20.setDisable(true);
                E20.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E21")) {
                E21.setDisable(true);
                E21.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E22")) {
                E22.setDisable(true);
                E22.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E23")) {
                E23.setDisable(true);
                E23.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E24")) {
                E24.setDisable(true);
                E24.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E25")) {
                E25.setDisable(true);
                E25.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F10")) {
                F10.setDisable(true);
                F10.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F11")) {
                F11.setDisable(true);
                F11.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F12")) {
                F12.setDisable(true);
                F12.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F13")) {
                F13.setDisable(true);
                F13.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F14")) {
                F14.setDisable(true);
                F14.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F15")) {
                F15.setDisable(true);
                F15.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F16")) {
                F16.setDisable(true);
                F16.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F17")) {
                F17.setDisable(true);
                F17.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F18")) {
                F18.setDisable(true);
                F18.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F19")) {
                F19.setDisable(true);
                F19.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F20")) {
                F20.setDisable(true);
                F20.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F21")) {
                F21.setDisable(true);
                F21.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F22")) {
                F22.setDisable(true);
                F22.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F23")) {
                F23.setDisable(true);
                F23.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F24")) {
                F24.setDisable(true);
                F24.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F25")) {
                F25.setDisable(true);
                    F25.setStyle("-fx-background-color: coral");
            }

        }}
        A1.setDisable(true);
        A2.setDisable(true);
        A3.setDisable(true);
        A4.setDisable(true);
        A5.setDisable(true);
        A6.setDisable(true);
        A7.setDisable(true);
        A8.setDisable(true);
        A9.setDisable(true);
        B1.setDisable(true);
        B2.setDisable(true);
        B3.setDisable(true);
        B4.setDisable(true);
        B5.setDisable(true);
        B6.setDisable(true);
        B7.setDisable(true);
        B8.setDisable(true);
        B9.setDisable(true);
        C1.setDisable(true);
        C2.setDisable(true);
        C3.setDisable(true);
        C4.setDisable(true);
        C5.setDisable(true);
        C6.setDisable(true);
        C7.setDisable(true);
        C8.setDisable(true);
        C9.setDisable(true);
        D1.setDisable(true);
        D2.setDisable(true);
        D3.setDisable(true);
        D4.setDisable(true);
        D5.setDisable(true);
        D6.setDisable(true);
        D7.setDisable(true);
        D8.setDisable(true);
        D9.setDisable(true);

        E1.setDisable(true);
        E2.setDisable(true);
        E3.setDisable(true);
        E4.setDisable(true);
        E5.setDisable(true);
        E6.setDisable(true);
        E7.setDisable(true);
        E8.setDisable(true);
        E9.setDisable(true);

        F1.setDisable(true);
        F2.setDisable(true);
        F3.setDisable(true);
        F4.setDisable(true);
        F5.setDisable(true);
        F6.setDisable(true);
        F7.setDisable(true);
        F8.setDisable(true);
        F9.setDisable(true);
    }
    else if(c_lass.equals("Business")){
        if(arrayList.size()!=0)
        {for(String seat:arrayList){

            if(seat.equals("A5")){
                A5.setDisable(true);
                A5.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A6")){

                A6.setDisable(true);
                A6.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A7")){
                A7.setDisable(true);
                A7.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A8")){
                A8.setDisable(true);
                A8.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A9")){
                A9.setDisable(true);
                A9.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B5")){
                B5.setDisable(true);
                B5.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B6")){
                B6.setDisable(true);
                B6.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B7")){
                B7.setDisable(true);
                B7.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B8")){
                B8.setDisable(true);
                B8.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B9")){
                B9.setDisable(true);
                B9.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C5")){
                C5.setDisable(true);
                C5.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C6")){
                C6.setDisable(true);
                C6.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C7")){
                C7.setDisable(true);
                C7.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C8")){
                C8.setDisable(true);
                C8.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C9")){
                C9.setDisable(true);
                C9.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D5")){
                D5.setDisable(true);
                D5.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D6")){
                D6.setDisable(true);
                D6.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D7")){
                D7.setDisable(true);
                D7.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D8")){
                D8.setDisable(true);
                D8.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D9")){
                D9.setDisable(true);
                    D9.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E5")){
                E5.setDisable(true);
                E5.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E6")){
                E6.setDisable(true);
                E6.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E7")){
                E7.setDisable(true);
                E7.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E8")){
                E8.setDisable(true);
                E8.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E9")){
                E9.setDisable(true);
                E9.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F5")){
                F5.setDisable(true);
                F5.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F6")){
                F6.setDisable(true);
                F6.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F7")){
                F7.setDisable(true);
                F7.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F8")){
                F8.setDisable(true);
                F8.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F9")){
                F9.setDisable(true);
                F9.setStyle("-fx-background-color: coral");
            }

        }}

        A1.setDisable(true);
        A2.setDisable(true);
        A3.setDisable(true);
        A4.setDisable(true);
        B1.setDisable(true);
        B2.setDisable(true);
        B3.setDisable(true);
        B4.setDisable(true);
        C1.setDisable(true);
        C2.setDisable(true);
        C3.setDisable(true);
        C4.setDisable(true);
        D1.setDisable(true);
        D2.setDisable(true);
        D3.setDisable(true);
        D4.setDisable(true);
        E1.setDisable(true);
        E2.setDisable(true);
        E3.setDisable(true);
        E4.setDisable(true);
        E1.setDisable(true);
        E2.setDisable(true);
        E3.setDisable(true);
        E4.setDisable(true);
        F1.setDisable(true);
        F2.setDisable(true);
        F3.setDisable(true);
        F4.setDisable(true);
        A10.setDisable(true);
        A11.setDisable(true);
        A12.setDisable(true);
        A13.setDisable(true);
        A14.setDisable(true);
        A15.setDisable(true);
        A16.setDisable(true);
        A17.setDisable(true);
        A18.setDisable(true);
        A19.setDisable(true);
        A20.setDisable(true);
        A21.setDisable(true);
        A22.setDisable(true);
        A23.setDisable(true);
        A24.setDisable(true);
        A25.setDisable(true);
        // Disable buttons from B10 to B25
        B10.setDisable(true);
        B11.setDisable(true);
        B12.setDisable(true);
        B13.setDisable(true);
        B14.setDisable(true);
        B15.setDisable(true);
        B16.setDisable(true);
        B17.setDisable(true);
        B18.setDisable(true);
        B19.setDisable(true);
        B20.setDisable(true);
        B21.setDisable(true);
        B22.setDisable(true);
        B23.setDisable(true);
        B24.setDisable(true);
        B25.setDisable(true);

// Disable buttons from C10 to C25
        C10.setDisable(true);
        C11.setDisable(true);
        C12.setDisable(true);
        C13.setDisable(true);
        C14.setDisable(true);
        C15.setDisable(true);
        C16.setDisable(true);
        C17.setDisable(true);
        C18.setDisable(true);
        C19.setDisable(true);
        C20.setDisable(true);
        C21.setDisable(true);
        C22.setDisable(true);
        C23.setDisable(true);
        C24.setDisable(true);
        C25.setDisable(true);

// Disable buttons from D10 to D25
        D10.setDisable(true);
        D11.setDisable(true);
        D12.setDisable(true);
        D13.setDisable(true);
        D14.setDisable(true);
        D15.setDisable(true);
        D16.setDisable(true);
        D17.setDisable(true);
        D18.setDisable(true);
        D19.setDisable(true);
        D20.setDisable(true);
        D21.setDisable(true);
        D22.setDisable(true);
        D23.setDisable(true);
        D24.setDisable(true);
        D25.setDisable(true);

// Disable buttons from E10 to E25
        E10.setDisable(true);
        E11.setDisable(true);
        E12.setDisable(true);
        E13.setDisable(true);
        E14.setDisable(true);
        E15.setDisable(true);
        E16.setDisable(true);
        E17.setDisable(true);
        E18.setDisable(true);
        E19.setDisable(true);
        E20.setDisable(true);
        E21.setDisable(true);
        E22.setDisable(true);
        E23.setDisable(true);
        E24.setDisable(true);
        E25.setDisable(true);

// Disable buttons from F10 to F25
        F10.setDisable(true);
        F11.setDisable(true);
        F12.setDisable(true);
        F13.setDisable(true);
        F14.setDisable(true);
        F15.setDisable(true);
        F16.setDisable(true);
        F17.setDisable(true);
        F18.setDisable(true);
        F19.setDisable(true);
        F20.setDisable(true);
        F21.setDisable(true);
        F22.setDisable(true);
        F23.setDisable(true);
        F24.setDisable(true);
        F25.setDisable(true);

    }
    else{
        if(arrayList.size()!=0)
        {for(String seat:arrayList){
            if(seat.equals("A1")){
                A1.setDisable(true);
                A1.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A2")){
                A2.setDisable(true);
                A2.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A3")){
                A3.setDisable(true);
                A3.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("A4")){
                A4.setDisable(true);
                A4.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B1")){
                B1.setDisable(true);
                B1.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B2")){
                B2.setDisable(true);
                B2.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B3")){
                B3.setDisable(true);
                B3.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("B4")){
                B4.setDisable(true);
                    B4.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C1")){
                C1.setDisable(true);
                C1.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C2")){
                C2.setDisable(true);
                    C2.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C3")){
                C3.setDisable(true);
                C3.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("C4")){
                C4.setDisable(true);
                    C4.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D1")){
                D1.setDisable(true);
                D1.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D2")){
                D2.setDisable(true);
                D2.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D3")){
                D3.setDisable(true);
                D3.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("D4")){
                D4.setDisable(true);
                D4.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E1")){
                E1.setDisable(true);
                E1.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E2")){
                E2.setDisable(true);
                E2.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E3")){
                E3.setDisable(true);
                E3.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("E4")){
                E4.setDisable(true);
                E4.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F1")){
                F1.setDisable(true);
                F1.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F2")){
                F2.setDisable(true);
                F2.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F3")){
                F3.setDisable(true);
                F3.setStyle("-fx-background-color: coral");
            }
            else if(seat.equals("F4")){
                F4.setDisable(true);
                F4.setStyle("-fx-background-color: coral");
            }



        }}
        A5.setDisable(true);
        A6.setDisable(true);
        A7.setDisable(true);
        A8.setDisable(true);
        A9.setDisable(true);

        B5.setDisable(true);
        B6.setDisable(true);
        B7.setDisable(true);
        B8.setDisable(true);
        B9.setDisable(true);

// Disable buttons from C5 to C9
        C5.setDisable(true);
        C6.setDisable(true);
        C7.setDisable(true);
        C8.setDisable(true);
        C9.setDisable(true);

// Disable buttons from D5 to D9
        D5.setDisable(true);
        D6.setDisable(true);
        D7.setDisable(true);
        D8.setDisable(true);
        D9.setDisable(true);

// Disable buttons from E5 to E9
        E5.setDisable(true);
        E6.setDisable(true);
        E7.setDisable(true);
        E8.setDisable(true);
        E9.setDisable(true);

// Disable buttons from F5 to F9
        F5.setDisable(true);
        F6.setDisable(true);
        F7.setDisable(true);
        F8.setDisable(true);
        F9.setDisable(true);

        A10.setDisable(true);
        A11.setDisable(true);
        A12.setDisable(true);
        A13.setDisable(true);
        A14.setDisable(true);
        A15.setDisable(true);
        A16.setDisable(true);
        A17.setDisable(true);
        A18.setDisable(true);
        A19.setDisable(true);
        A20.setDisable(true);
        A21.setDisable(true);
        A22.setDisable(true);
        A23.setDisable(true);
        A24.setDisable(true);
        A25.setDisable(true);
        // Disable buttons from B10 to B25
        B10.setDisable(true);
        B11.setDisable(true);
        B12.setDisable(true);
        B13.setDisable(true);
        B14.setDisable(true);
        B15.setDisable(true);
        B16.setDisable(true);
        B17.setDisable(true);
        B18.setDisable(true);
        B19.setDisable(true);
        B20.setDisable(true);
        B21.setDisable(true);
        B22.setDisable(true);
        B23.setDisable(true);
        B24.setDisable(true);
        B25.setDisable(true);

// Disable buttons from C10 to C25
        C10.setDisable(true);
        C11.setDisable(true);
        C12.setDisable(true);
        C13.setDisable(true);
        C14.setDisable(true);
        C15.setDisable(true);
        C16.setDisable(true);
        C17.setDisable(true);
        C18.setDisable(true);
        C19.setDisable(true);
        C20.setDisable(true);
        C21.setDisable(true);
        C22.setDisable(true);
        C23.setDisable(true);
        C24.setDisable(true);
        C25.setDisable(true);

// Disable buttons from D10 to D25
        D10.setDisable(true);
        D11.setDisable(true);
        D12.setDisable(true);
        D13.setDisable(true);
        D14.setDisable(true);
        D15.setDisable(true);
        D16.setDisable(true);
        D17.setDisable(true);
        D18.setDisable(true);
        D19.setDisable(true);
        D20.setDisable(true);
        D21.setDisable(true);
        D22.setDisable(true);
        D23.setDisable(true);
        D24.setDisable(true);
        D25.setDisable(true);

// Disable buttons from E10 to E25
        E10.setDisable(true);
        E11.setDisable(true);
        E12.setDisable(true);
        E13.setDisable(true);
        E14.setDisable(true);
        E15.setDisable(true);
        E16.setDisable(true);
        E17.setDisable(true);
        E18.setDisable(true);
        E19.setDisable(true);
        E20.setDisable(true);
        E21.setDisable(true);
        E22.setDisable(true);
        E23.setDisable(true);
        E24.setDisable(true);
        E25.setDisable(true);

// Disable buttons from F10 to F25
        F10.setDisable(true);
        F11.setDisable(true);
        F12.setDisable(true);
        F13.setDisable(true);
        F14.setDisable(true);
        F15.setDisable(true);
        F16.setDisable(true);
        F17.setDisable(true);
        F18.setDisable(true);
        F19.setDisable(true);
        F20.setDisable(true);
        F21.setDisable(true);
        F22.setDisable(true);
        F23.setDisable(true);
        F24.setDisable(true);
        F25.setDisable(true);

    }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIdTicket();
        if(count==0){
            vbox2.setVisible(false);
            vbox1.setVisible(true);

        }



      //  setIdTicket(idp,flightNo,flightName,fromCity,toCity,date,time,airport,availableSeat,bookedseat,c_lass);

        B1.setOnAction(e -> handleToggleButtonAction(B1));
        B2.setOnAction(e -> handleToggleButtonAction(B2));
        B3.setOnAction(e -> handleToggleButtonAction(B3));
        B4.setOnAction(e -> handleToggleButtonAction(B4));
        B5.setOnAction(e -> handleToggleButtonAction(B5));
        B6.setOnAction(e -> handleToggleButtonAction(B6));
        B7.setOnAction(e -> handleToggleButtonAction(B7));
        B8.setOnAction(e -> handleToggleButtonAction(B8));
        B9.setOnAction(e -> handleToggleButtonAction(B9));
        B10.setOnAction(e -> handleToggleButtonAction(B10));
        B11.setOnAction(e -> handleToggleButtonAction(B11));
        B12.setOnAction(e -> handleToggleButtonAction(B12));
        B13.setOnAction(e -> handleToggleButtonAction(B13));
        B14.setOnAction(e -> handleToggleButtonAction(B14));
        B15.setOnAction(e -> handleToggleButtonAction(B15));
        B16.setOnAction(e -> handleToggleButtonAction(B16));
        B17.setOnAction(e -> handleToggleButtonAction(B17));
        B18.setOnAction(e -> handleToggleButtonAction(B18));
        B19.setOnAction(e -> handleToggleButtonAction(B19));
        B20.setOnAction(e -> handleToggleButtonAction(B20));
        B21.setOnAction(e -> handleToggleButtonAction(B21));
        B22.setOnAction(e -> handleToggleButtonAction(B22));
        B23.setOnAction(e -> handleToggleButtonAction(B23));
        B24.setOnAction(e -> handleToggleButtonAction(B24));
        B25.setOnAction(e -> handleToggleButtonAction(B25));

        A1.setOnAction(e -> handleToggleButtonAction(A1));
        A2.setOnAction(e -> handleToggleButtonAction(A2));
        A3.setOnAction(e -> handleToggleButtonAction(A3));
        A4.setOnAction(e -> handleToggleButtonAction(A4));
        A5.setOnAction(e -> handleToggleButtonAction(A5));
        A6.setOnAction(e -> handleToggleButtonAction(A6));
        A7.setOnAction(e -> handleToggleButtonAction(A7));
        A8.setOnAction(e -> handleToggleButtonAction(A8));
        A9.setOnAction(e -> handleToggleButtonAction(A9));
        A10.setOnAction(e -> handleToggleButtonAction(A10));
        A11.setOnAction(e -> handleToggleButtonAction(A11));
        A12.setOnAction(e -> handleToggleButtonAction(A12));
        A13.setOnAction(e -> handleToggleButtonAction(A13));
        A14.setOnAction(e -> handleToggleButtonAction(A14));
        A15.setOnAction(e -> handleToggleButtonAction(A15));
        A16.setOnAction(e -> handleToggleButtonAction(A16));
        A17.setOnAction(e -> handleToggleButtonAction(A17));
        A18.setOnAction(e -> handleToggleButtonAction(A18));
        A19.setOnAction(e -> handleToggleButtonAction(A19));
        A20.setOnAction(e -> handleToggleButtonAction(A20));
        A21.setOnAction(e -> handleToggleButtonAction(A21));
        A22.setOnAction(e -> handleToggleButtonAction(A22));
        A23.setOnAction(e -> handleToggleButtonAction(A23));
        A24.setOnAction(e -> handleToggleButtonAction(A24));
        A25.setOnAction(e -> handleToggleButtonAction(A25));

        C2.setOnAction(e -> handleToggleButtonAction(C2));
        C3.setOnAction(e -> handleToggleButtonAction(C3));
        C4.setOnAction(e -> handleToggleButtonAction(C4));
        C5.setOnAction(e -> handleToggleButtonAction(C5));
        C6.setOnAction(e -> handleToggleButtonAction(C6));
        C7.setOnAction(e -> handleToggleButtonAction(C7));
        C8.setOnAction(e -> handleToggleButtonAction(C8));
        C9.setOnAction(e -> handleToggleButtonAction(C9));
        C10.setOnAction(e -> handleToggleButtonAction(C10));
        C11.setOnAction(e -> handleToggleButtonAction(C11));
        C12.setOnAction(e -> handleToggleButtonAction(C12));
        C13.setOnAction(e -> handleToggleButtonAction(C13));
        C14.setOnAction(e -> handleToggleButtonAction(C14));
        C15.setOnAction(e -> handleToggleButtonAction(C15));
        C16.setOnAction(e -> handleToggleButtonAction(C16));
        C17.setOnAction(e -> handleToggleButtonAction(C17));
        C18.setOnAction(e -> handleToggleButtonAction(C18));
        C19.setOnAction(e -> handleToggleButtonAction(C19));
        C20.setOnAction(e -> handleToggleButtonAction(C20));
        C21.setOnAction(e -> handleToggleButtonAction(C21));
        C22.setOnAction(e -> handleToggleButtonAction(C22));
        C23.setOnAction(e -> handleToggleButtonAction(C23));
        C24.setOnAction(e -> handleToggleButtonAction(C24));
        C25.setOnAction(e -> handleToggleButtonAction(C25));

        D1.setOnAction(e -> handleToggleButtonAction(D1));
        D2.setOnAction(e -> handleToggleButtonAction(D2));
        D3.setOnAction(e -> handleToggleButtonAction(D3));
        D4.setOnAction(e -> handleToggleButtonAction(D4));
        D5.setOnAction(e -> handleToggleButtonAction(D5));
        D6.setOnAction(e -> handleToggleButtonAction(D6));
        D7.setOnAction(e -> handleToggleButtonAction(D7));
        D8.setOnAction(e -> handleToggleButtonAction(D8));
        D9.setOnAction(e -> handleToggleButtonAction(D9));
        D10.setOnAction(e -> handleToggleButtonAction(D10));
        D11.setOnAction(e -> handleToggleButtonAction(D11));
        D12.setOnAction(e -> handleToggleButtonAction(D12));
        D13.setOnAction(e -> handleToggleButtonAction(D13));
        D14.setOnAction(e -> handleToggleButtonAction(D14));
        D15.setOnAction(e -> handleToggleButtonAction(D15));
        D16.setOnAction(e -> handleToggleButtonAction(D16));
        D17.setOnAction(e -> handleToggleButtonAction(D17));
        D18.setOnAction(e -> handleToggleButtonAction(D18));
        D19.setOnAction(e -> handleToggleButtonAction(D19));
        D20.setOnAction(e -> handleToggleButtonAction(D20));
        D21.setOnAction(e -> handleToggleButtonAction(D21));
        D22.setOnAction(e -> handleToggleButtonAction(D22));
        D23.setOnAction(e -> handleToggleButtonAction(D23));
        D24.setOnAction(e -> handleToggleButtonAction(D24));
        D25.setOnAction(e -> handleToggleButtonAction(D25));

        E1.setOnAction(e -> handleToggleButtonAction(E1));
        E2.setOnAction(e -> handleToggleButtonAction(E2));
        E3.setOnAction(e -> handleToggleButtonAction(E3));
        E4.setOnAction(e -> handleToggleButtonAction(E4));
        E5.setOnAction(e -> handleToggleButtonAction(E5));
        E6.setOnAction(e -> handleToggleButtonAction(E6));
        E7.setOnAction(e -> handleToggleButtonAction(E7));
        E8.setOnAction(e -> handleToggleButtonAction(E8));
        E9.setOnAction(e -> handleToggleButtonAction(E9));
        E10.setOnAction(e -> handleToggleButtonAction(E10));
        E11.setOnAction(e -> handleToggleButtonAction(E11));
        E12.setOnAction(e -> handleToggleButtonAction(E12));
        E13.setOnAction(e -> handleToggleButtonAction(E13));
        E14.setOnAction(e -> handleToggleButtonAction(E14));
        E15.setOnAction(e -> handleToggleButtonAction(E15));
        E16.setOnAction(e -> handleToggleButtonAction(E16));
        E17.setOnAction(e -> handleToggleButtonAction(E17));
        E18.setOnAction(e -> handleToggleButtonAction(E18));
        E19.setOnAction(e -> handleToggleButtonAction(E19));
        E20.setOnAction(e -> handleToggleButtonAction(E20));
        E21.setOnAction(e -> handleToggleButtonAction(E21));
        E22.setOnAction(e -> handleToggleButtonAction(E22));
        E23.setOnAction(e -> handleToggleButtonAction(E23));
        E24.setOnAction(e -> handleToggleButtonAction(E24));
        E25.setOnAction(e -> handleToggleButtonAction(E25));

        F1.setOnAction(e -> handleToggleButtonAction(F1));
        F2.setOnAction(e -> handleToggleButtonAction(F2));
        F3.setOnAction(e -> handleToggleButtonAction(F3));
        F4.setOnAction(e -> handleToggleButtonAction(F4));
        F5.setOnAction(e -> handleToggleButtonAction(F5));
        F6.setOnAction(e -> handleToggleButtonAction(F6));
        F7.setOnAction(e -> handleToggleButtonAction(F7));
        F8.setOnAction(e -> handleToggleButtonAction(F8));
        F9.setOnAction(e -> handleToggleButtonAction(F9));
        F10.setOnAction(e -> handleToggleButtonAction(F10));
        F11.setOnAction(e -> handleToggleButtonAction(F11));
        F12.setOnAction(e -> handleToggleButtonAction(F12));
        F13.setOnAction(e -> handleToggleButtonAction(F13));
        F14.setOnAction(e -> handleToggleButtonAction(F14));
        F15.setOnAction(e -> handleToggleButtonAction(F15));
        F16.setOnAction(e -> handleToggleButtonAction(F16));
        F17.setOnAction(e -> handleToggleButtonAction(F17));
        F18.setOnAction(e -> handleToggleButtonAction(F18));
        F19.setOnAction(e -> handleToggleButtonAction(F19));
        F20.setOnAction(e -> handleToggleButtonAction(F20));
        F21.setOnAction(e -> handleToggleButtonAction(F21));
        F22.setOnAction(e -> handleToggleButtonAction(F22));
        F23.setOnAction(e -> handleToggleButtonAction(F23));
        F24.setOnAction(e -> handleToggleButtonAction(F24));
        F25.setOnAction(e -> handleToggleButtonAction(F25));



    }
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void handleToggleButtonAction(ToggleButton selectbtn) {count++;
        if(count>0){
            vbox1.setVisible(false);
            vbox2.setVisible(true);
        }

    }
}

