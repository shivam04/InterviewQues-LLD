package splitwise.model.constant;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public enum PaidStatus {
    PAID,
    NOT_PAID;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}
