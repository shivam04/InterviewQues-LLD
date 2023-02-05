package ParkingManagemntService.repository;

import ParkingManagemntService.models.Vehicle;

import javax.inject.Named;

@Named
public class VehicleRepository {
    public Vehicle save(Vehicle vehicle) {
        return vehicle;
    }

    public Vehicle get(String vehicleNumber) {
        return null;
    }
}
