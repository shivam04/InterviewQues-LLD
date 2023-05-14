package splitwise.model.constant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
public enum ExpenseStatus {
    OPEN,
    SETTLED;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
