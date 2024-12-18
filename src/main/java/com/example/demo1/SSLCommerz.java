package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.sql.*;

public class SSLCommerz {

    @FXML
    private StackPane root;
    @FXML
    private WebView webView;
    public static double totalAmount = 1300;

    private static final String STORE_ID = "allgo675d65afe0ac3"; // Replace with your test Store ID
    private static final String STORE_PASSWORD = "allgo675d65afe0ac3@ssl"; // Replace with your test Password
    private static final String TRANSACTION_URL = "https://sandbox.sslcommerz.com/gwprocess/v4/api.php";

    public void initialize() {
        handleProceedToCheckout();
    }

    private String createPaymentSession() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            Map<String, String> params = new HashMap<>();
            params.put("store_id", STORE_ID);
            params.put("store_passwd", STORE_PASSWORD);
            params.put("total_amount", String.valueOf(totalAmount));  // Use dynamic totalAmount
            params.put("currency", "BDT");  // Set to BDT for Bangladesh
            params.put("tran_id", "TEST_" + System.currentTimeMillis());
            params.put("success_url", "http://127.0.0.1:1000/success_done");
            params.put("fail_url", "http://127.0.0.1:1000/faildone");
            params.put("cancel_url", "http://127.0.0.1:1000/canceldone");
            params.put("cus_name", "Test Customer");
            params.put("cus_email", "test@example.com");
            params.put("cus_add1", "Test Address");
            params.put("cus_city", "Dhaka");
            params.put("cus_postcode", "1207");
            params.put("cus_country", "Bangladesh");
            params.put("cus_phone", "01700000000");
            params.put("shipping_method", "NO");
            params.put("product_name", "ride");
            params.put("product_category", "service");
            params.put("product_profile", "general");

            String form = params.entrySet().stream()
                    .map(entry -> URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "=" +
                            URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(TRANSACTION_URL))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(form))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseJson = response.body();
            System.out.println(responseJson);

            if (responseJson.contains("\"GatewayPageURL\"")) {
                int startIndex = responseJson.indexOf("\"GatewayPageURL\":\"") + 18;
                int endIndex = responseJson.indexOf("\"", startIndex);
                return responseJson.substring(startIndex, endIndex).replace("\\/", "/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void handleProceedToCheckout() {
        try {
            String paymentUrl = createPaymentSession();
            if (paymentUrl != null) {
                webView.getEngine().load(paymentUrl);
            } else {
                showAlert("Failed", "Failed to create payment request.");
                return;
            }
            webView.getEngine().locationProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.contains("success_done")) {
                    webView.getEngine().loadContent("");  // Clear the WebView content
                    showSuccessAlert("Payment completed successfully!");
                    navigateToHomepage();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while processing the payment.");
        }
    }

    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);  // Change alert type to INFORMATION
        alert.setTitle("Payment Completed");
        alert.setHeaderText(null);  // Remove the header text
        alert.setContentText(message);  // Display the success message
        alert.showAndWait();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void navigateToHomepage() {
        String insertQuery = "INSERT INTO Customer_details (Class,Nid,SeatNumber,TicketNumber,Destination,passport,Departure,Date,Time,Username,Gmail,TicketPrice,FlightNo,FlightName,AirportName)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";

        Connection connectDB = DatabaseConnection.databaseLink;

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            // Set parameters for the query
            preparedStatement.setString(1, customer.cClass);
            preparedStatement.setString(2, customer.nId);
            preparedStatement.setString(3, customer.updatedTickets);
            preparedStatement.setInt(4, customer.cticketCount);
            preparedStatement.setString(5, customer.cdestination);
            preparedStatement.setString(6, customer.cPass);
            preparedStatement.setString(7, customer.cDeparture);
            preparedStatement.setString(8, customer.cDate);
            preparedStatement.setString(9, customer.cTime);
            preparedStatement.setString(10, customer.cUsername);
            preparedStatement.setString(11, customer.cEmail);
            preparedStatement.setDouble(12, customer.cprice);
            preparedStatement.setString(13, customer.cFlightno);
            preparedStatement.setString(14, customer.cFlightname);
            preparedStatement.setString(15, customer.cAirport);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Show success message if insertion is successful
            if (rowsAffected > 0) {
                showAlert("Success", "Customer details have been added successfully!", Alert.AlertType.INFORMATION);

                String fetchQuery = "SELECT ReservationN0 FROM Customer_details WHERE Class=? AND Nid=? AND SeatNumber=? AND TicketNumber=? AND Destination=? AND passport=? AND Departure=? AND Date=? AND Time=? AND Username=? AND Gmail=? AND TicketPrice=? AND FlightNo=? AND FlightName=? AND AirportName=? ";

                try (PreparedStatement preparedStatement1 = connectDB.prepareStatement(fetchQuery)) {
                    // Set parameters for the query
                    preparedStatement1.setString(1, customer.cClass);
                    preparedStatement1.setString(2, customer.nId);
                    preparedStatement1.setString(3, customer.updatedTickets);
                    preparedStatement1.setInt(4, customer.cticketCount);
                    preparedStatement1.setString(5, customer.cdestination);
                    preparedStatement1.setString(6, customer.cPass);
                    preparedStatement1.setString(7, customer.cDeparture);
                    preparedStatement1.setString(8, customer.cDate);
                    preparedStatement1.setString(9, customer.cTime);
                    preparedStatement1.setString(10, customer.cUsername);
                    preparedStatement1.setString(11, customer.cEmail);
                    preparedStatement1.setDouble(12, customer.cprice);
                    preparedStatement1.setString(13, customer.cFlightno);
                    preparedStatement1.setString(14, customer.cFlightname);
                    preparedStatement1.setString(15, customer.cAirport);

                    ResultSet queryResult = preparedStatement1.executeQuery();

                    if (queryResult.next()) {
                        // Fetch the reservation number
                        long reservationNumber = queryResult.getLong("ReservationN0");
                        // Show the reservation number in an alert
                        showAlert("Reservation Details", "Your Reservation Number: " + reservationNumber, Alert.AlertType.INFORMATION);

                        // Send an email with the reservation number
                        if (customer.cEmail.isEmpty()) {
                            showAlert("Error", "Please enter a valid email address!", Alert.AlertType.ERROR);
                            return;
                        }

                        // Email subject and body
                        String subject = "Your Flight Reservation Details";
                        String body = "Dear " + customer.cUsername + ",\n\n" +
                                "Thank you for your booking!\n\n" +
                                "Here are your reservation details:\n" +
                                "Reservation Number: " + reservationNumber + "\n" +
                                "Seat Number: " + customer.updatedTickets + "\n" +
                                "Ticket Price: " + customer.cprice + "\n\n" +
                                "We wish you a pleasant journey!\n\n" +
                                "Best regards,\nYour Flight Team";

                        // Send the email
                        boolean emailSent = sendEmail(customer.cEmail, subject, body);

                        if (emailSent) {
                            showAlert("Success", "Email sent successfully to " + customer.cEmail, Alert.AlertType.INFORMATION);
                        } else {
                            showAlert("Error", "Failed to send the email. Please try again!", Alert.AlertType.ERROR);
                        }
                    } else {
                        // No reservation found for the user
                        showAlert("No Reservation Found", "No reservation found for the provided username.", Alert.AlertType.ERROR);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to fetch reservation details: " + e.getMessage(), Alert.AlertType.ERROR);
                }
            } else {
                showAlert("Error", "Failed to add customer details. Please try again.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while saving the Customer details: " + e.getMessage(), Alert.AlertType.ERROR);
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) webView.getScene().getWindow();
            stage.close();

            stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean sendEmail(String recipientEmail, String subject, String body) {
        final String senderEmail = "islam2107008@stud.kuet.ac.bd"; // Your email
        final String senderPassword = "nugs jrgv qtjk jhqi";       // Your email password

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Use javax.mail.Authenticator
        Authenticator authenticator = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully!");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
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
