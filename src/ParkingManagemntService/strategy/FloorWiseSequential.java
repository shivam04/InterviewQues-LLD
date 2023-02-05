package ParkingManagemntService.strategy;

import ParkingManagemntService.beans.BeansConstants;
import ParkingManagemntService.models.ParkingSpot;
import ParkingManagemntService.models.VehicleType;

import javax.inject.Named;

@Named(BeansConstants.FloorWiseSequentialStrategy)
public class FloorWiseSequential implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocate(VehicleType vehicleType, Long gateNumber) {
        return null;
    }
}
