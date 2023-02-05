package ParkingManagemntService.models;

import lombok.Data;

@Data
public class ElectricParkingSpot extends BaseModel{
    private ParkingSpot parkingSpot;
    private ElectricCharger electricCharger;
}
