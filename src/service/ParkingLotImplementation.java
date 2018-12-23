package service;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public enum ParkingLotImplementation {

    IN_MEMORY("in_memory", new ParkingServiceInMemory());

    /*
    IN_MEMORY("in_memory", new ParkingServiceInMemory(),
    DATABASE("database", new ParkingServiceDatabase));
    */

    private String implementationType;
    private ParkingService parkingService;

    ParkingLotImplementation(String implementationType, ParkingService parkingService) {
        this.implementationType = implementationType;
        this.parkingService = parkingService;
    }

    public String getImplementationType() {
        return implementationType;
    }

    public ParkingService getParkingService() {
        return parkingService;
    }
}
