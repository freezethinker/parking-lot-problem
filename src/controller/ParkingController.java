package controller;

import domain.ParkingLot;
import service.ParkingLotImplementation;
import service.ParkingService;
import utils.Inputs;
import utils.Messages;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public class ParkingController {

    private ParkingService parkingService;

    public void init(String implementationType) {
            parkingService = ParkingLotImplementation.valueOf(implementationType).getParkingService();
    }

    public List<ParkingLot> handle(List<ParkingLot> parkingLots, String inputType) {

        String command[] = inputType.split(" ", 2);
        String commandType = command[0];

        if(Inputs.CREATE_PARKING_LOT.equals(commandType)) {

            String numSlots = inputType.split(" ", 2)[1];
            parkingLots = parkingService.createParkingSlot(Integer.parseInt(numSlots));
            System.out.println(Messages.CREATING_PARKING + numSlots + Messages.SLOTS);

            return parkingLots;
        }

        else if(Inputs.PARK.equals(commandType)) {

            String regNum = inputType.split(" ", 3)[1];
            String color = inputType.split(" ", 3)[2];

            parkingService.parkCar(parkingLots, regNum, color);

        }

        else if(Inputs.LEAVE.equals(commandType)) {

            String leaveSlotId = inputType.split(" ", 2)[1];

            parkingService.leaveCar(parkingLots, Integer.parseInt(leaveSlotId));

        }

        else if(Inputs.STATUS.equals(commandType)) {

            parkingService.printStatus(parkingLots);
        }

        else if(Inputs.CARS_WITH_COLOR.equals(commandType)) {

            String color = inputType.split(" ", 2)[1];

            List<String> carWithColor;
            carWithColor = parkingService.findCarWithColor(parkingLots, color);

            for(String carNum: carWithColor) {
                System.out.println(carNum);
            }
        }

        else if(Inputs.SLOTS_WITH_COLOR.equals(commandType)) {

            String color = inputType.split(" ", 2)[1];

            List<Integer> slotsWithColor;
            slotsWithColor = parkingService.findSlotWithColor(parkingLots, color);


            for(Integer slot: slotsWithColor) {
                System.out.println(slot);
            }
        }

        else if(Inputs.SLOT_NUM_FOR_CAR.equals(commandType)) {

            String carNum = inputType.split(" ", 2)[1];
            int slot = parkingService.findCarWithSlot(parkingLots, carNum);
            if(slot == Integer.MAX_VALUE) System.out.println(Messages.NOT_FOUND);
            else
                System.out.println(Messages.SLOT_NO + slot);
        }

        else
            System.out.println(Messages.INVALID_COMMAND);


        return parkingLots;
    }
}
