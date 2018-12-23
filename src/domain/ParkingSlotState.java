package domain;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public enum ParkingSlotState {
    VACANT("vacant"),
    OCCUPIED("occupied"),
    MAINTENANCE("maintenance");

    private String state;

    ParkingSlotState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}