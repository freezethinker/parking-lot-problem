package domain;

import java.util.Date;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public class ParkingLot {

    int id;

    ParkingFloor floor = ParkingFloor.GROUND;

    ParkingSlotState status = ParkingSlotState.VACANT;

    Slot slot;

    Vehicle vehicle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSlotState getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotState status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
