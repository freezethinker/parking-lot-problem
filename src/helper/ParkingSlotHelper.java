package helper;

import domain.ParkingLot;
import domain.ParkingSlotState;
import domain.Slot;
import domain.Vehicle;
import domain.VehicleType;

import java.util.Date;
import java.util.List;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public class ParkingSlotHelper {

    public static List<ParkingLot> initParkingSlots(List<ParkingLot> parkingLots) {
        int id = 0;
        for(ParkingLot parkingLot: parkingLots) {
            ParkingLot lot = new ParkingLot();
            lot.setId(++id);
            parkingLots.add(lot);
        }
        return parkingLots;
    }

    public static int getMinParkingSlot(List<ParkingLot> parkingLots) {
        int id = Integer.MAX_VALUE;
        for(ParkingLot parkingLot: parkingLots) {
            if(parkingLot.getStatus().equals(ParkingSlotState.VACANT) && parkingLot.getId() < id)
                id = parkingLot.getId();
        }
        return id;
    }

    /*public static List<ParkingLot> parkAtId(List<ParkingLot> parkingLots, int idToPark, String regNum, String color) {
        for(ParkingLot parkingLot: parkingLots) {
            if(parkingLot.getId() == idToPark) {

                parkingLot.setStatus(ParkingSlotState.OCCUPIED);
                Vehicle vehicle = new Vehicle(regNum, color, VehicleType.CAR);
                vehicle.setInTime(new Date());

                Slot slot = new Slot();

                parkingLot.setVehicle(vehicle);
                parkingLot.setSlot(slot);
            }
        }
        return parkingLots;
    }*/

    public static void parkAtId(List<ParkingLot> parkingLots, int idToPark, String regNum, String color) {
        for(ParkingLot parkingLot: parkingLots) {
            if(parkingLot.getId() == idToPark) {

                parkingLot.setStatus(ParkingSlotState.OCCUPIED);
                Vehicle vehicle = new Vehicle(regNum, color, VehicleType.CAR);
                vehicle.setInTime(new Date());

                Slot slot = new Slot();

                parkingLot.setVehicle(vehicle);
                parkingLot.setSlot(slot);
            }
        }
    }
}
