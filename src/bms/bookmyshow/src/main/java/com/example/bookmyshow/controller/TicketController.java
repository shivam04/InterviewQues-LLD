package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.TicketBookingRequest;
import com.example.bookmyshow.dto.TicketBookingResponse;
import com.example.bookmyshow.exception.ShowAndShowSeatAreNotRelatedException;
import com.example.bookmyshow.exception.ShowNotAvailableException;
import com.example.bookmyshow.exception.ShowSeatNotAvailableException;
import com.example.bookmyshow.model.Ticket;
import com.example.bookmyshow.service.TicketService;
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
