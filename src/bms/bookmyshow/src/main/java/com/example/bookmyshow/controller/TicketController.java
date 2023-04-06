package bms.bookmyshow.src.main.java.com.example.bookmyshow.controller;

import bms.bookmyshow.src.main.java.com.example.bookmyshow.dto.TicketBookingRequest;
import bms.bookmyshow.src.main.java.com.example.bookmyshow.dto.TicketBookingResponse;
import bms.bookmyshow.src.main.java.com.example.bookmyshow.exception.ShowAndShowSeatAreNotRelatedException;
import bms.bookmyshow.src.main.java.com.example.bookmyshow.exception.ShowNotAvailableException;
import bms.bookmyshow.src.main.java.com.example.bookmyshow.exception.ShowSeatNotAvailableException;
import bms.bookmyshow.src.main.java.com.example.bookmyshow.model.Ticket;
import bms.bookmyshow.src.main.java.com.example.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketBookingResponse bookTicket(TicketBookingRequest ticketBookingRequest) throws ShowNotAvailableException,
            ShowAndShowSeatAreNotRelatedException,
            ShowSeatNotAvailableException {
        if(ticketBookingRequest.getShowId() != null && ticketBookingRequest.getShowSeatIds() !=null
                &&  ticketBookingRequest.getShowSeatIds().size() > 0) {
            Ticket ticket = ticketService.bookTicket(ticketBookingRequest.getShowSeatIds(),
                    ticketBookingRequest.getShowId());
            TicketBookingResponse successTicketResponse = new TicketBookingResponse();
            successTicketResponse.setStatus("success");
            successTicketResponse.setTicket(ticket);
            return successTicketResponse;
        }

        TicketBookingResponse ticketBookingResponse =  new TicketBookingResponse();
        ticketBookingResponse.setMessage("Failure, not valid inputs, please give showId or Provide Seats");
        ticketBookingResponse.setStatus("failure");
        return ticketBookingResponse;
    }
}
