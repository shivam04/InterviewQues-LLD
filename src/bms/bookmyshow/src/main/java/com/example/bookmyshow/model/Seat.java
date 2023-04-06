package bms.bookmyshow.src.main.java.com.example.bookmyshow.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;
    private int col;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
