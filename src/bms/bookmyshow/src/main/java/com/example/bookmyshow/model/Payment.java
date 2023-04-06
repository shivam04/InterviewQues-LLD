package bms.bookmyshow.src.main.java.com.example.bookmyshow.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private double amount;
    private String referenceId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;


    @ManyToOne
    private Ticket ticket;
}
