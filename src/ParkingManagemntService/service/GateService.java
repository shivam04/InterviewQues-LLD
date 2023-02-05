package ParkingManagemntService.service;

import ParkingManagemntService.models.Gate;
import ParkingManagemntService.repository.GateRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GateService {

    private final GateRepository repository;

    @Inject
    public GateService(GateRepository repository) {
        this.repository = repository;
    }

    public Gate getGateByNumber(Long gateNumber) {
        return repository.get(gateNumber);
    }
}
