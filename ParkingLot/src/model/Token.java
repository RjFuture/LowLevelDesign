package model;

import java.util.Date;

public class Token extends BaseEntity{

    private String token;
    private Date entryTime;
    private Vehicle vehicle;
    private Gate gate;
    private ParkingSlot slot;
}
