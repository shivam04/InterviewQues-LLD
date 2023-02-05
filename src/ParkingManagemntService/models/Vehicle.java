package ParkingManagemntService.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle extends BaseModel{
    private VehicleType vehicleType;
    private String number;
}
