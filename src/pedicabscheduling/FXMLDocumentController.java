package pedicabscheduling;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private TableColumn<Pedicab, String> pedicabColumnNumber;
    @FXML
    private TextField driverNameSched;
    @FXML
    private TextField operatorNameSched;
    @FXML
    private TextField pedicabNumberSched;
    @FXML
    private TextField pedicabModelSched;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Label DateStartLabel;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Label DateEndLabel;
    @FXML
    private ListView<String> driverListView;
    private Connection connection;
    @FXML
    private ListView<String> operatorListviewSched;
    @FXML
    private ListView<String> pedicabListviewSched;
    @FXML
    private ListView<String> pedicabModelListviewSched;
    
   
    
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
        pedicabModelListviewSched.setVisible(false);
        driverListView.setVisible(false);
        operatorListviewSched.setVisible(false);
        pedicabListviewSched.setVisible(false);
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
    
    @FXML
    private void addSchedule(ActionEvent event) {
    Schedule schedule = new Schedule();

    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to MySQL database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedicabsys", "root", "Kjjdkp5119326")) {

            // Prepare the SQL statement
            String sql = "INSERT INTO Schedule (driver_id, pedicab_id, operator_id, start_time, end_time) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, schedule.getDriverId());
                preparedStatement.setInt(2, schedule.getPedicabId());
                preparedStatement.setInt(3, schedule.getOperatorId());
                preparedStatement.setObject(4, schedule.getStartTime());
                preparedStatement.setObject(5, schedule.getEndTime());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception appropriately (show an error message, log it, etc.)
            }
        }

        // You can add a success message or clear the fields after successful insertion
        System.out.println("Schedule added successfully");
        // Clear the JavaFX fields
        driverNameSched.setText(null);
        pedicabModelSched.setText(null);
        operatorNameSched.setText(null);
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
       
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
    
    
    
    @FXML
    private void handleKeyTypedSchedDriver(KeyEvent key) {
    TextField searchTextField = driverNameSched;
    String userInput = searchTextField.getText().trim();

    // Clear previous suggestions
    driverListView.getItems().clear();

    if (!userInput.isEmpty()) {
        // Search for matching driver names
        List<String> matchingDrivers = searchDrivers(userInput);

        // Add matching drivers to the driverListView
        driverListView.getItems().addAll(matchingDrivers);

        // Show the suggestion list
        driverListView.setVisible(!matchingDrivers.isEmpty());

        // Handle selection when Enter key is pressed
        driverListView.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleDriverSelection();
            }
        });

        // Handle selection when an item is clicked
        driverListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { // Single click
                handleDriverSelection();
            }
        });

    } else {
        // Hide the suggestion list if the search field is empty
        driverListView.setVisible(false);
    }
    
    
}
    
    private void handleDriverSelection() {
    // Get the selected item from the list view
    String selectedDriver = driverListView.getSelectionModel().getSelectedItem();

    if (selectedDriver != null) {
        
        // Set the selected value back to the TextField
        driverNameSched.setText(selectedDriver);

        // Hide the suggestion list
        driverListView.setVisible(false);
    }
}

    private List<String> searchDrivers(String userInput) {
    List<String> matchingDrivers = new ArrayList<>();

    String query = "SELECT driver_name FROM driver WHERE driver_name LIKE ?";
    connection = DatabaseConnection.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, "%" + userInput + "%");
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                matchingDrivers.add(resultSet.getString("driver_name"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return matchingDrivers;
}
    
    @FXML
    private void handleKeyTypedSchedOperator(KeyEvent key) {
    TextField searchTextField = operatorNameSched;
    String userInput = searchTextField.getText().trim();

    // Clear previous suggestions
    operatorListviewSched.getItems().clear();

    if (!userInput.isEmpty()) {
        // Search for matching driver names
        List<String> matchingOperators = searchOperators(userInput);

        // Add matching drivers to the driverListView
        operatorListviewSched.getItems().addAll(matchingOperators);

        // Show the suggestion list
        operatorListviewSched.setVisible(!matchingOperators.isEmpty());

        // Handle selection when Enter key is pressed
        operatorListviewSched.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleOperatorSelection();
            }
        });

        // Handle selection when an item is clicked
        operatorListviewSched.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { 
                handleOperatorSelection();
            }
        });

    } else {
        // Hide the suggestion list if the search field is empty
        operatorListviewSched.setVisible(false);
    }
    
    
}
    private List<String> searchOperators(String userInput) {
    List<String> matchingOperators = new ArrayList<>();

    String query = "SELECT operator_name FROM operator WHERE operator_name LIKE ?";
    connection = DatabaseConnection.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, "%" + userInput + "%");
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                matchingOperators.add(resultSet.getString("operator_name"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return matchingOperators;
}
    private void handleOperatorSelection() {
    // Get the selected item from the list view
    String selectedDriver = operatorListviewSched.getSelectionModel().getSelectedItem();

    if (selectedDriver != null) {
        // Set the selected value back to the TextField
        operatorNameSched.setText(selectedDriver);

        // Hide the suggestion list
        operatorListviewSched.setVisible(false);
    }
}
    
   @FXML
    private void handleKeyTypedSchedPedicabNumber(KeyEvent key) {
    TextField searchTextField = pedicabNumberSched;
    String userInput = searchTextField.getText().trim();

    // Clear previous suggestions
    pedicabListviewSched.getItems().clear();

    if (!userInput.isEmpty()) {
        // Search for matching driver names
        List<String> matchingPedicabNum = searchPedicabNumber(userInput);

        // Add matching drivers to the driverListView
        pedicabListviewSched.getItems().addAll(matchingPedicabNum);

        // Show the suggestion list
        pedicabListviewSched.setVisible(!matchingPedicabNum.isEmpty());

        // Handle selection when Enter key is pressed
        pedicabListviewSched.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handlePedicabNumberSelection();
            }
        });

        // Handle selection when an item is clicked
        pedicabListviewSched.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { 
                handlePedicabNumberSelection();
            }
        });

    } else {
        // Hide the suggestion list if the search field is empty
        pedicabListviewSched.setVisible(false);
    }
    
    
}
    private List<String> searchPedicabNumber(String userInput) {
    List<String> matchingPedicabNum = new ArrayList<>();

    String query = "SELECT pedicab_number FROM pedicab WHERE pedicab_number LIKE ?";
    connection = DatabaseConnection.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, "%" + userInput + "%");
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                matchingPedicabNum.add(resultSet.getString("pedicab_number"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return matchingPedicabNum;
}
    private void handlePedicabNumberSelection() {
    // Get the selected item from the list view
    String selectedPedicabNum = pedicabListviewSched.getSelectionModel().getSelectedItem();

    if (selectedPedicabNum != null) {
        // Set the selected value back to the TextField
        pedicabNumberSched.setText(selectedPedicabNum);

        // Hide the suggestion list
        pedicabListviewSched.setVisible(false);
    }
}
    
    @FXML
    private void handleKeyTypedSchedPedicabModel(KeyEvent key) {
    TextField searchTextField = pedicabModelSched;
    String userInput = searchTextField.getText().trim();

    // Clear previous suggestions
    pedicabModelListviewSched.getItems().clear();

    if (!userInput.isEmpty()) {
        // Search for matching driver names
        List<String> matchingPedicabModel = searchPedicabModel(userInput);

        // Add matching drivers to the driverListView
        pedicabModelListviewSched.getItems().addAll(matchingPedicabModel);

        // Show the suggestion list
        pedicabModelListviewSched.setVisible(!matchingPedicabModel.isEmpty());

        // Handle selection when Enter key is pressed
        pedicabModelListviewSched.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handlePedicabModelSelection();
            }
        });

        // Handle selection when an item is clicked
        pedicabModelListviewSched.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { 
                handlePedicabModelSelection();
            }
        });

    } else {
        // Hide the suggestion list if the search field is empty
        pedicabModelListviewSched.setVisible(false);
    }
    
    
}
    private List<String> searchPedicabModel(String userInput) {
    List<String> matchingPedicabModel = new ArrayList<>();

    String query = "SELECT model FROM pedicab WHERE model LIKE ?";
    connection = DatabaseConnection.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, "%" + userInput + "%");
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                matchingPedicabModel.add(resultSet.getString("model"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return matchingPedicabModel;
}
    private void handlePedicabModelSelection() {
    // Get the selected item from the list view
    String selectedPedicabModel = pedicabModelListviewSched.getSelectionModel().getSelectedItem();

    if (selectedPedicabModel != null) {
        // Set the selected value back to the TextField
        pedicabModelSched.setText(selectedPedicabModel);

        // Hide the suggestion list
        pedicabModelListviewSched.setVisible(false);
    }
}
}

