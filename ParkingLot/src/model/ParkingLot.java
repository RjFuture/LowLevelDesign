package model;

import java.util.List;

public class ParkingLot extends BaseEntity {

    private String address;
    private List<ParkingFloor> floors;
    private List<Gate> gates;

    // for ForeignKey
    private ParkingStatus parkingStatus; // it can be open or close or under maintenance

    // steategy will add later

    // 1.) pricing strategy
    // 2.) Allocation strategy
}
