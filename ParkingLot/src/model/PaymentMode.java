package model;

public class PaymentMode extends BaseEntity{
    private String mode; //like cash, card,Upi

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
