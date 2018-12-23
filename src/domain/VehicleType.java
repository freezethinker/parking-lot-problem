package domain;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public enum VehicleType {
    BIKE("bike", "small"),
    CAR("car", "medium"),
    VAN("van", "large"),
    TRUCK("truck", "extra_large");

    private String name;
    private String slotSize;

    VehicleType(String name, String slotSize) {
        this.name = name;
        this.slotSize = slotSize;
    }

    public String getName() {
        return name;
    }

    public String getSlotSize() {
        return slotSize;
    }
}
