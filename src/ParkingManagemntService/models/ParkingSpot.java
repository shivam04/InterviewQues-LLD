package ParkingManagemntService.models;

import lombok.Data;

import java.util.List;

@Data
public class ParkingSpot extends BaseModel{
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleTypes;
    private int number;
}
