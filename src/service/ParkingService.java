package service;

import domain.ParkingLot;
import java.util.List;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public interface ParkingService {

    public List<ParkingLot> createParkingSlot(int numSlots);

    public void parkCar(List<ParkingLot> parkingLots, String regNum, String color);

    public void leaveCar(List<ParkingLot> parkingLots, int leaveSlotId);

    public List<String> findCarWithColor(List<ParkingLot> parkingLots, String color);

    public List<Integer> findSlotWithColor(List<ParkingLot> parkingLots, String color);

    public int findCarWithSlot(List<ParkingLot> parkingLots, String carNum);

    public void printStatus(List<ParkingLot> parkingLots);

}
