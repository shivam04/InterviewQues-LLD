package bms.bookmyshow.src.main.java.com.example.bookmyshow.validator;

import bms.bookmyshow.src.main.java.com.example.bookmyshow.dto.TicketBookingRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class TicketRequestValidator {
    public boolean validate(TicketBookingRequest ticketBookingRequest) {
        return (ticketBookingRequest.getShowId() != null ||
                !CollectionUtils.isEmpty(ticketBookingRequest.getShowSeatIds()));
    }
}
