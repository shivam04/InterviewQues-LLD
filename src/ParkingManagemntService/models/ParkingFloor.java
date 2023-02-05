package ParkingManagemntService.models;

import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor extends BaseModel{
    private int number;
    private List<ParkingSpot> parkingSpots;
}
