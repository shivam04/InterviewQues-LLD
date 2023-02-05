package ParkingManagemntService.dtos;

import ParkingManagemntService.models.VehicleType;
import lombok.Data;

@Data
public class CreateTicketRequestDTO {
    private Long gateNumber;
    private String vehicleNumber;
    private VehicleType type;
}
