package pedicabscheduling;
import javafx.beans.property.*;


public class Operator {
    private final IntegerProperty operatorId = new SimpleIntegerProperty();
    private final StringProperty operatorName = new SimpleStringProperty();
    private final StringProperty contactNumber = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();

    public Operator() {
        
    }

    Operator(int operatorId, String operatorName, String operatorNumber, String address) {
        this.operatorId.set(operatorId);
        this.operatorName.set(operatorName);
        this.contactNumber.set(operatorNumber);
        this.address.set(address);
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
