package model;

import Strategy.PricingStrategy;
import Strategy.SlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseEntity {

    private String address;
    private List<ParkingFloor> floors;
    private List<Gate> gates;

    // for ForeignKey
    private ParkingStatus parkingStatus; // it can be open or close or under maintenance

    // steategy will add later

    private PricingStrategy pricingStrategy;
    private SlotAllocationStrategy slotAllocationStrategy;

    // 1.) pricing strategy
    // 2.) Allocation strategy


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(ParkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }
}
