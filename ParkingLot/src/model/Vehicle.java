package model;

public class Vehicle extends BaseEntity{

    private String vehicleNumber;
    private String ownerName;

    // this will be foreign key for vehicleType
    private VehicleType vehicleType;

}
