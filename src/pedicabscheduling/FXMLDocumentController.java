package pedicabscheduling;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


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
    private TextField pedicabNumberTxtField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField regNoTextField;
    //Driver 
    @FXML
    private TableView<Driver> tableView;
    @FXML
    private TableColumn<Driver, Integer> idColumn;
    @FXML
    private TableColumn<Driver, String> nameColumn;
    @FXML
    private TableColumn<Driver, String> licenseColumn;
    @FXML
    private TableColumn<Driver, String> contactColumn;
    @FXML
    private TableColumn<Driver, String> addressColumn;
    //Pedicab
    @FXML
    private TableView<Pedicab> pedicabTableView;
    @FXML
    private TableView<?> ScheduleTableVIew;
    //Operator 
    @FXML
    private TableView<Operator> operatorTableView;
    @FXML
    private TableColumn<Operator, Integer> operatorColumnId;
    
    @FXML
    private TableColumn<Operator, String> operatorColumnContact;
    @FXML
    private TableColumn<Operator, String> operatorColumnAddress;
    @FXML
    private TableColumn<Operator, String> operatorColumnName;
    @FXML
    private TableColumn<Pedicab, Integer> pedicabColumnId;
    @FXML
    private TableColumn<Pedicab, String> pedicabColumnModel;
    @FXML
    private TableColumn<Pedicab, String> pedicabRegistrationNo;
    @FXML
    private TableColumn<?, ?> pedicabColumnNumber;
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //drivers column
    idColumn.setCellValueFactory(new PropertyValueFactory<>("driverId"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));
    licenseColumn.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));
    contactColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    //operator column
    operatorColumnId.setCellValueFactory(new PropertyValueFactory<>("operatorId"));
    operatorColumnName.setCellValueFactory(new PropertyValueFactory<>("operatorName"));
    operatorColumnContact.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
    operatorColumnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    
    //pedicab column table view
    pedicabColumnId.setCellValueFactory(new PropertyValueFactory<>("pedicabId"));
    pedicabColumnNumber.setCellValueFactory(new PropertyValueFactory<>("pedicabNumber"));
    pedicabColumnModel.setCellValueFactory(new PropertyValueFactory<>("model"));
    pedicabRegistrationNo.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
    try {
        ObservableList<Driver> driverList = getDrivers();
        tableView.setItems(driverList);
        ObservableList<Operator> operatorList = getOperators();
        operatorTableView.setItems(operatorList);
        ObservableList<Pedicab> pedicabList = getPedicabs();
        pedicabTableView.setItems(pedicabList);
     } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
    

    
    @FXML
    private void addDrivers(ActionEvent event) throws ClassNotFoundException {
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
            
            //update the table view of the driver
            ObservableList<Driver> driverList = getDrivers();
            tableView.setItems(driverList);
            
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
            
            //update the table view of the driver
            ObservableList<Operator> operatorList = getOperators();
            operatorTableView.setItems(operatorList);
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
            ObservableList<Pedicab> pedicabList = getPedicabs();
            pedicabTableView.setItems(pedicabList);
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
    
    
    private ObservableList<Driver> getDrivers() throws ClassNotFoundException {
    ObservableList<Driver> driverList = FXCollections.observableArrayList();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to MySQL database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326");

        String sql = "SELECT * FROM driver";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int driverId = resultSet.getInt("driver_id");
            String driverName = resultSet.getString("driver_name");
            String licenseNumber = resultSet.getString("license_number");
            String contactNumber = resultSet.getString("contact_number");
            String address = resultSet.getString("address");

            driverList.add(new Driver(driverId, driverName, licenseNumber, contactNumber, address));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return driverList;
}

    private ObservableList<Operator> getOperators() throws ClassNotFoundException {
    ObservableList<Operator> operatorList = FXCollections.observableArrayList();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to MySQL database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326");

        String sql = "SELECT * FROM operator";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int operatorId = resultSet.getInt("operator_id");
            String operatorName = resultSet.getString("operator_name");
            String operatorNumber = resultSet.getString("contact_number");
            String address = resultSet.getString("address");

            operatorList.add(new Operator(operatorId, operatorName, operatorNumber, address));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return operatorList;
}
    
    private ObservableList<Pedicab> getPedicabs() throws ClassNotFoundException {
    ObservableList<Pedicab> pedicabList = FXCollections.observableArrayList();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to MySQL database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326");

        String sql = "SELECT * FROM pedicab";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int pedicabId = resultSet.getInt("pedicab_id");
            String pedicabNumber = resultSet.getString("pedicab_number");
            String model = resultSet.getString("model");
            String registrationNumber = resultSet.getString("registration_number");

            pedicabList.add(new Pedicab(pedicabId, pedicabNumber, model, registrationNumber));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pedicabList;
}
}

