package ParkingManagemntService.strategy;

import ParkingManagemntService.models.ParkingSpot;
import ParkingManagemntService.models.VehicleType;

public interface SpotAllocationStrategy {
    ParkingSpot allocate(VehicleType vehicleType, Long gateNumber);
}
