package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection databaseLink=null;

    static {
        getConnection();
    }

    public Connection getDatabaseLink() {
        return databaseLink;
    }

    public static void getConnection() {
        // Database credentials
        String databaseName = "bowbmibbyuuwbje4tbj2";
        String databaseUser = "up5nwqztcjl0row6";  // Removed extra space after 'root'
        String databasePassword = "gpdqnqKkXHkRxVrTTtxZ";

        // Corrected JDBC URL
        String url = "jdbc:mysql://bowbmibbyuuwbje4tbj2-mysql.services.clever-cloud.com/" + databaseName;

        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            if(databaseLink==null) {
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);}

        } catch (ClassNotFoundException e) {
            // This handles the case where the JDBC driver is not found
            e.printStackTrace();
        } catch (SQLException e) {
            // This handles SQL errors such as incorrect credentials or unreachable DB
            e.printStackTrace();
        }

       // return databaseLink;  // Return the connection or null if there's an error
    }
}
