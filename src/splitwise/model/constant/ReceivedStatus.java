package splitwise.model.constant;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public enum ReceivedStatus {
    RECEIVED,
    NOT_RECEIVED;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}
