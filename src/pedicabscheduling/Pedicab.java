
package pedicabscheduling;
import javafx.beans.property.*;
/**
 *
 * @author hugoj
 */
public class Pedicab {
    private final IntegerProperty pedicabId = new SimpleIntegerProperty();
    private final StringProperty pedicabNumber = new SimpleStringProperty();
    private final StringProperty model = new SimpleStringProperty();
    private final StringProperty registrationNumber = new SimpleStringProperty();

    public Pedicab() {
        // Default constructor
    }

    Pedicab(int pedicabId, String pedicabNumber, String model, String registrationNumber) {
       this.pedicabId.set(pedicabId);
       this.pedicabNumber.set(pedicabNumber);
       this.model.set(model);
       this.registrationNumber.set(registrationNumber);
    }
    // Getters and setters for each property
    public int getPedicabId() {
        return pedicabId.get();
    }

    public void setPedicabId(int pedicabId) {
        this.pedicabId.set(pedicabId);
    }

    public IntegerProperty pedicabIdProperty() {
        return pedicabId;
    }

    public String getPedicabNumber() {
        return pedicabNumber.get();
    }

    public void setPedicabNumber(String pedicabNumber) {
        this.pedicabNumber.set(pedicabNumber);
    }

    public StringProperty pedicabNumberProperty() {
        return pedicabNumber;
    }

    public String getModel() {
        return model.get();
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public StringProperty modelProperty() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber.get();
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber.set(registrationNumber);
    }

    public StringProperty registrationNumberProperty() {
        return registrationNumber;
    }
}
