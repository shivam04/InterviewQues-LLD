package ParkingManagemntService.models;

import lombok.Data;

@Data
public class Gate extends BaseModel{
    private GateType gateType;
    private Operator operator;
}
