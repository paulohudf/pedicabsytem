
package pedicabscheduling;
import javafx.beans.property.*;
import java.time.LocalDateTime;
/**
 *
 * @author hugoj
 */
public class Schedule {
    private final IntegerProperty scheduleId = new SimpleIntegerProperty();
    private final IntegerProperty driverId = new SimpleIntegerProperty();
    private final IntegerProperty pedicabId = new SimpleIntegerProperty();
    private final IntegerProperty operatorId = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDateTime> startTime = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDateTime> endTime = new SimpleObjectProperty<>();

    public Schedule() {
        // Default constructor
    }

    // Getters and setters for each property
    public int getScheduleId() {
        return scheduleId.get();
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId.set(scheduleId);
    }

    public IntegerProperty scheduleIdProperty() {
        return
scheduleId;
}
    
    public int getDriverId() {
    return driverId.get();
}

public void setDriverId(int driverId) {
    this.driverId.set(driverId);
}

public IntegerProperty driverIdProperty() {
    return driverId;
}

public int getPedicabId() {
    return pedicabId.get();
}

public void setPedicabId(int pedicabId) {
    this.pedicabId.set(pedicabId);
}

public IntegerProperty pedicabIdProperty() {
    return pedicabId;
}

public int getOperatorId() {
    return operatorId.get();
}

public void setOperatorId(int operatorId) {
    this.operatorId.set(operatorId);
}

public IntegerProperty operatorIdProperty() {
    return operatorId;
}

public LocalDateTime getStartTime() {
    return startTime.get();
}

public void setStartTime(LocalDateTime startTime) {
    this.startTime.set(startTime);
}

public ObjectProperty<LocalDateTime> startTimeProperty() {
    return startTime;
}

public LocalDateTime getEndTime() {
    return endTime.get();
}

public void setEndTime(LocalDateTime endTime) {
    this.endTime.set(endTime);
}

public ObjectProperty<LocalDateTime> endTimeProperty() {
    return endTime;
}
    
}
