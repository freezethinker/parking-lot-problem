package service;

import domain.ParkingLot;
import domain.ParkingSlotState;
import domain.Vehicle;
import domain.VehicleType;
import helper.ParkingSlotHelper;
import utils.Messages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public class ParkingServiceInMemory implements ParkingService {


    public List<ParkingLot> createParkingSlot(int numSlots) {

        List<ParkingLot> parkingLots = new ArrayList<>(numSlots);
        for (int i = 1; i <= numSlots; i++) {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setId(i);
            parkingLots.add(parkingLot);
        }

        return parkingLots;

    }

    public void parkCar(List<ParkingLot> parkingLots, String regNum, String color) {

        int idToPark = ParkingSlotHelper.getMinParkingSlot(parkingLots);
        ParkingSlotHelper.parkAtId(parkingLots, idToPark, regNum, color);

        if (idToPark == Integer.MAX_VALUE) System.out.println(Messages.PARKING_FULL);
        else System.out.println(Messages.ALLOCATED_SLOT_NUMBER + idToPark);

    }

   public void leaveCar(List<ParkingLot> parkingLots, int leaveSlotId) {

        for (ParkingLot parkingLot : parkingLots) {

            if (parkingLot.getId() == leaveSlotId) {
                parkingLot.getVehicle().setOutTime(new Date());
                Long diffTime = parkingLot.getVehicle().getOutTime().getTime() - parkingLot.getVehicle().getInTime().getTime();

                System.out.println(
                        Messages.HR +
                                Messages.TIME_SPENT + (diffTime / 1000) + Messages.SECONDS +
                                Messages.TOTAL_BILL + Messages.RUPEES +
                                parkingLot.getSlot().getSlotCategory().getPrice() * ((diffTime / 1000) > 0 ? (diffTime / 1000) : 1) +
                                Messages.EXIT_TIME + parkingLot.getVehicle().getOutTime() +
                                Messages.ENTRY_TIME + parkingLot.getVehicle().getInTime() +
                                "\n" + Messages.HR);

                parkingLot.setStatus(ParkingSlotState.VACANT);
                Vehicle vehicle = new Vehicle("", "", VehicleType.CAR);
                parkingLot.setVehicle(vehicle);
            }
        }
    }

    public List<String> findCarWithColor(List<ParkingLot> parkingLots, String color) {

        List<String> carWithColor = new ArrayList<>();

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVehicle().getVehicleColor().equals(color)) {
                carWithColor.add(parkingLot.getVehicle().getRegistrationNumber());
            }
        }

        return carWithColor;
    }

    public List<Integer> findSlotWithColor(List<ParkingLot> parkingLots, String color) {

        List<Integer> slotWithColor = new ArrayList<>();

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVehicle().getVehicleColor().equals(color)) {
                slotWithColor.add(parkingLot.getId());
            }
        }

        return slotWithColor;
    }

    public int findCarWithSlot(List<ParkingLot> parkingLots, String carNum) {

        int slot = Integer.MAX_VALUE;

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVehicle().getRegistrationNumber().equals(carNum)) {
                slot = parkingLot.getId();
            }
        }

        return slot;
    }

    public void printStatus(List<ParkingLot> parkingLots) {

        if (parkingLots.size() > 0) {
            int count = 0;
            System.out.println(Messages.HR + "\n" +
                    "No.\tRegistration\tSlot No.\tColor\t\n" +
                    Messages.HR);
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getStatus().equals(ParkingSlotState.OCCUPIED)) {
                    System.out.println(++count + "\t" +
                            parkingLot.getVehicle().getRegistrationNumber() + "\t" +
                            parkingLot.getId() + "\t\t\t" +
                            parkingLot.getVehicle().getVehicleColor()
                    );
                }
            }
            System.out.println("--------------------------------------");
        } else System.out.println(Messages.PARKING_NOT_INITIATED);
    }
}
