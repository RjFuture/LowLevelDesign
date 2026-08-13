package model;

public class ParkingSlot extends BaseEntity {

    private String slotNumber;
    private VehicleType vehicleType;
    private SlotStatus slotStatus;
    private Vehicle vehicle;

    //this is just for Bidirectional relationship
    private ParkingFloor floor;
}
