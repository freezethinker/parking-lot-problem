package domain;

import java.util.Date;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public class Vehicle {

    private String registrationNumber;

    private String vehicleColor;

    private VehicleType vehicleType;

    private Date inTime;

    private Date outTime;

    public Vehicle(String registrationNumber, String vehicleColor, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleColor = vehicleColor;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", vehicleColor=" + vehicleColor +
                ", vehicleType=" + vehicleType +
                '}';
    }
}