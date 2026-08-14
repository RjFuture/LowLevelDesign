package model;

public class GateType extends BaseEntity{

    private String type; // gate type entrylevel, exitlevel
    // In future can have vip gate too


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
