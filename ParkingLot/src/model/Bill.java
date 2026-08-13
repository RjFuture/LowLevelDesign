package model;

import java.util.Date;
import java.util.List;

public class Bill extends BaseEntity{
    private double amount;
    private Date exitTime;
    private Token token;
    private List<Payment> payments; // will do partila payments like some from cash and some from card
    private Gate gate;
}
