package splitwise.model.constant;

import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Entity
public enum Currency {
    INR,
    USD,
    GBP,
    EUR,
    JPY;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}
