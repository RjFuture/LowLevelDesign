package model;

public class PaymentStatus extends BaseEntity{
    private String status; //can be successful, failed and blocked

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
