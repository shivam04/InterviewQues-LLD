package ParkingManagemntService.dtos;

import ParkingManagemntService.models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
