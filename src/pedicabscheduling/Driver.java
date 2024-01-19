/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedicabscheduling;
import javafx.beans.property.*;
/**
 *
 * @author hugoj
 */
public class Driver {
    private final IntegerProperty driverId = new SimpleIntegerProperty();
    private final StringProperty driverName = new SimpleStringProperty();
    private final StringProperty licenseNumber = new SimpleStringProperty();
    private final StringProperty contactNumber = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();

    public Driver() {
        // Default constructor
    }

    // Getters and setters for each property
    public int getDriverId() {
        return driverId.get();
    }

    public void setDriverId(int driverId) {
        this.driverId.set(driverId);
    }

    public IntegerProperty driverIdProperty() {
        return driverId;
    }

    public String getDriverName() {
        return driverName.get();
    }

    public void setDriverName(String driverName) {
        this.driverName.set(driverName);
    }

    public StringProperty driverNameProperty() {
        return driverName;
    }

    public String getLicenseNumber() {
        return licenseNumber.get();
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber.set(licenseNumber);
    }

    public StringProperty licenseNumberProperty() {
        return licenseNumber;
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }

    public StringProperty contactNumberProperty() {
        return contactNumber;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }
}
