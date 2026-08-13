package model;

public class Gate extends BaseEntity{

    private String gateNumber;

    // this will be foreign key for gateType and gateStatus
    private GateType gateType;
    private GateStatus gateStatus;
}
