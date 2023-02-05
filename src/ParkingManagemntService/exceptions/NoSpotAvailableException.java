package ParkingManagemntService.exceptions;

public class NoSpotAvailableException extends Exception{
    public NoSpotAvailableException(String message) {
        super(message);
    }
}
