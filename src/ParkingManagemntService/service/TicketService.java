package ParkingManagemntService.service;

import ParkingManagemntService.dtos.CreateTicketRequestDTO;
import ParkingManagemntService.exceptions.GateNotFoundException;
import ParkingManagemntService.exceptions.NoSpotAvailableException;
import ParkingManagemntService.models.*;
import ParkingManagemntService.repository.TicketRepository;
import ParkingManagemntService.strategy.SpotAllocationStrategy;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
public class TicketService {

    private final VehicleService vehicleService;
    private final GateService gateService;
    private final SpotAllocationStrategy allocationStrategyFactory;
    private final TicketRepository repository;

    @Inject
    public TicketService(VehicleService vehicleService, GateService gateService,
                         SpotAllocationStrategy allocationStrategyFactory, TicketRepository repository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.allocationStrategyFactory = allocationStrategyFactory;
        this.repository = repository;
    }

    public Ticket createTicket(CreateTicketRequestDTO createTicketRequestDTO) throws NoSpotAvailableException, GateNotFoundException {
        final String vehicleNumber = createTicketRequestDTO.getVehicleNumber();
        final VehicleType vehicleType = createTicketRequestDTO.getType();
        final Long gateNumber = createTicketRequestDTO.getGateNumber();

        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
        if (vehicle == null) {
            vehicle = vehicleService.addVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGateByNumber(gateNumber);
        if (gate == null) {
            throw new GateNotFoundException("No Gate Found!!");
        }

        ParkingSpot spot= allocationStrategyFactory.allocate(vehicleType, gateNumber);

        if (spot == null) {
            throw new NoSpotAvailableException("No Available Spot!!");
        }

        Ticket ticket = Ticket.builder()
                .dateEntry(new Date())
                .gate(gate)
                .vehicle(vehicle)
                .operator(gate.getOperator())
                .parkingSpot(spot)
                .build();
        Ticket savedTicket = repository.save(ticket);
        return savedTicket;
    }
}
