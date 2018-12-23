package domain;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public enum ParkingFloor {

    GROUND("ground"),
    FIRST("first"),
    SECOND("second"),
    THIRD("third");

    private String floor;

    ParkingFloor(String floor) {
        this.floor = floor;
    }
}
