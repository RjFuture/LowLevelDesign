package model;

public class Payment extends BaseEntity{

    private double amountPaid;
    private Bill bill;

    // will have foreign key with data from paymentStatus and paymentMode
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
