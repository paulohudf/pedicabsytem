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
public class Operator {
    private final IntegerProperty operatorId = new SimpleIntegerProperty();
    private final StringProperty operatorName = new SimpleStringProperty();
    private final StringProperty contactNumber = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();

    public Operator() {
        // Default constructor
    }

    // Getters and setters for each property
    public int getOperatorId() {
        return operatorId.get();
    }

    public void setOperatorId(int operatorId) {
        this.operatorId.set(operatorId);
    }

    public IntegerProperty operatorIdProperty() {
        return operatorId;
    }

    public String getOperatorName() {
        return operatorName.get();
    }

    public void setOperatorName(String operatorName) {
        this.operatorName.set(operatorName);
    }

    public StringProperty operatorNameProperty() {
        return operatorName;
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
