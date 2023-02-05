package ParkingManagemntService.strategy;

import ParkingManagemntService.beans.BeansConstants;
import ParkingManagemntService.models.ParkingSpot;
import ParkingManagemntService.models.VehicleType;

import javax.inject.Named;

@Named(BeansConstants.RandomAllocationStrategy)
public class RandomAllocation implements SpotAllocationStrategy{

    @Override
    public ParkingSpot allocate(VehicleType vehicleType, Long gateNumber) {
        return null;
    }
}
