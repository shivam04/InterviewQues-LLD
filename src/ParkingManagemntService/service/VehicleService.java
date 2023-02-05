package ParkingManagemntService.service;

import ParkingManagemntService.models.Vehicle;
import ParkingManagemntService.models.VehicleType;
import ParkingManagemntService.repository.VehicleRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VehicleService {

    private final VehicleRepository repository;

    @Inject
    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle getVehicleByNumber(String vehicleNumber) {
        return repository.get(vehicleNumber);
    }

    public Vehicle addVehicle(String vehicleNumber, VehicleType type) {
        Vehicle vehicle = Vehicle.builder()
                .vehicleType(type)
                .number(vehicleNumber)
                .build();
        return repository.save(vehicle);
    }
}
