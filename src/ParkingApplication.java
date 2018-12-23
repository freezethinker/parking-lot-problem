import controller.ParkingController;
import domain.ParkingLot;
import service.ParkingLotImplementation;
import utils.Inputs;
import utils.Messages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParkingApplication {

    private static final ParkingController PARKING_CONTROLLER = new ParkingController();

    public static void main(String[] args) {

        String command;
        int argumentLength = args.length;

        PARKING_CONTROLLER.init(ParkingLotImplementation.IN_MEMORY.getImplementationType().toUpperCase());
        List<ParkingLot> parkingLots = new ArrayList<>();

        switch (argumentLength) {
            case 0:
                while(true) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
                        command = bufferedReader.readLine();

                        if (Inputs.EXIT.equals(command)) {
                            return;
                        } else if (null == command || command.isEmpty()) {
                            System.out.println(Messages.EMPTY_COMMAND);
                        } else {
                            parkingLots = PARKING_CONTROLLER.handle(parkingLots, command);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            case 1:
                File inputFile = new File(args[0]);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(inputFile));
                    String line = null;
                    try {
                        while ((line = br.readLine()) != null) {
                            System.out.println(Messages.INPUT_TAG + line + Messages.OUTPUT_TAG);
                            parkingLots = PARKING_CONTROLLER.handle(parkingLots, line.trim());
                        }
                    } catch (Exception e) {
                        System.out.println(Messages.COMMAND_PARSING_ERROR);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(Messages.FILE_NOT_FOUND);
                }
                break;

            default:
                throw new IllegalArgumentException(Messages.ILLEGAL_ARGUMENTS);
        }
    }
}
