package model;

public class GateStatus extends BaseEntity{

    private String status;// gate status will be open or close or under maintenance

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
