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
    private TextField driverNameField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private TextField licenseNumberField;
    @FXML
    private TextField addressField;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextField driverNameField2;
    @FXML
    private TextField contactNumberField2;
    @FXML
    private TextField addressField1;
    @FXML
    private Button addBtnDrvr;
    @FXML
    private Label driverLabel;
    @FXML
    private TextField operatorName;
    @FXML
    private TextField operatorContact;
    @FXML
    private TextField operatorAddress;
    @FXML
    private Button addBtnOperator;
    @FXML
    private Label contactLabel;
    @FXML
    private Label licenseLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label operatorLabel;
    @FXML
    private Label contactOptLabel;
    @FXML
    private Label addressOptLabel;
    @FXML
    private Label pedicabLabel;
    @FXML
    private Label pedicalModelLabel;
    @FXML
    private Label registrationLabel;
    @FXML
    private Label driverDetailsLabel;
    @FXML
    private Label opratorDetailsLabel;
    @FXML
    private Label pedicabDetailsLabel;
    @FXML
    private Button addBtnSchedule;
    @FXML
    private Label driverLabel2;
    @FXML
    private Label operatorLabel2;
    @FXML
    private Label pedicabLabel2;
    @FXML
    private Label pedicabModelLabel;
    @FXML
    private Label scheduleDetailsLabel;
    @FXML
    private Button addBtnPedicab;
    @FXML
    private TextField pedicabNumber1;
    @FXML
    private TextField model1;
    @FXML
    private TextField regNo;
    @FXML
    private TextField pedicabNumberTxtField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField regNoTextField;
    
    
   
    
   
    
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
     @FXML
    private void addOperator(ActionEvent event) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326");

            // Prepare the SQL statement
            String sql = "INSERT INTO operator (operator_name,  contact_number, address) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, operatorName.getText());
                statement.setString(2, operatorContact.getText());
                statement.setString(3, operatorAddress.getText());
                

                // Execute the update
                statement.executeUpdate();
            }

            // Close the connection
            connection.close();

            // You can add a success message or clear the fields after successful insertion
            System.out.println("Operator added successfully");
            operatorName.clear();
            operatorContact.clear();
            operatorAddress.clear();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (show an error message, log it, etc.)
        }
    }
    
    @FXML
    private void addPedicab(ActionEvent event) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326");

            // Prepare the SQL statement
            String sql = "INSERT INTO pedicab (pedicab_number,  model, registration_number) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, pedicabNumberTxtField.getText());
                statement.setString(2, modelTextField.getText());
                statement.setString(3, regNoTextField.getText());
                

                // Execute the update
                statement.executeUpdate();
            }

            // Close the connection
            connection.close();

            // You can add a success message or clear the fields after successful insertion
            System.out.println("Pedicab added successfully");
            pedicabNumberTxtField.clear();
            modelTextField.clear();
            regNoTextField.clear();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (show an error message, log it, etc.)
        }
    }
}
