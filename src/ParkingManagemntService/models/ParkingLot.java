package ParkingManagemntService.models;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLostStatus;
    private String name;
    private String address;
}
