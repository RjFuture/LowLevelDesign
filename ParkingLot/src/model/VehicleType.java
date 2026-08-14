package model;

public class VehicleType extends BaseEntity{

    private String type; // like 2 wheeler, 4 wheeler, 3 wheeler

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
