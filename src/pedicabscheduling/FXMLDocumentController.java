/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pedicabscheduling;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author hugoj
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button addBtn;
    @FXML
    private TextField driverNameField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private TextField licenseNumberField;
    @FXML
    private TextField addressField;
    
    
   
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addButtonAction(ActionEvent event) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326");

            // Prepare the SQL statement
            String sql = "INSERT INTO driver (driver_name, license_number, contact_number, address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, driverNameField.getText());
                statement.setString(2, licenseNumberField.getText());
                statement.setString(3, contactNumberField.getText());
                statement.setString(4, addressField.getText());

                // Execute the update
                statement.executeUpdate();
            }

            // Close the connection
            connection.close();

            // You can add a success message or clear the fields after successful insertion
            System.out.println("Driver added successfully");
            driverNameField.clear();
            licenseNumberField.clear();
            contactNumberField.clear();
            addressField.clear();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (show an error message, log it, etc.)
        }
    }
}
