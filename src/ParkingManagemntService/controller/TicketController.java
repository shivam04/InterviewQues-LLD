package ParkingManagemntService.controller;

import ParkingManagemntService.dtos.CreateTicketRequestDTO;
import ParkingManagemntService.dtos.CreateTicketResponseDTO;
import ParkingManagemntService.dtos.ResponseStatus;
import ParkingManagemntService.exceptions.GateNotFoundException;
import ParkingManagemntService.exceptions.NoSpotAvailableException;
import ParkingManagemntService.models.Ticket;
import ParkingManagemntService.service.TicketService;

import javax.inject.Inject;

public class TicketController {
    private final TicketService ticketService;

    @Inject
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public CreateTicketResponseDTO createTicket(CreateTicketRequestDTO createTicketRequestDTO) {
        CreateTicketResponseDTO responseDTO = null;
        try {
            Ticket ticket = ticketService.createTicket(createTicketRequestDTO);
            responseDTO = new CreateTicketResponseDTO(ticket, ResponseStatus.SUCCESS);
        } catch (NoSpotAvailableException | GateNotFoundException exception) {
            responseDTO = new CreateTicketResponseDTO();
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
