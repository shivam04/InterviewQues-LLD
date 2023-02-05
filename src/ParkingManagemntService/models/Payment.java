package ParkingManagemntService.models;

import lombok.Data;

@Data
public class Payment extends BaseModel{
    private PaymentMethod paymentMethod;
    private int amount;
    private PaymentStatus paymentStatus;
    private String referenceId;
}
