package ParkingManagemntService.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Bill extends BaseModel{
    private Ticket ticket;
    private Date exitTime;
    private int amount;
    private Operator operator;
    private Gate gate;
    private List<Payment> payments;
    private BillStatus billStatus;
}
