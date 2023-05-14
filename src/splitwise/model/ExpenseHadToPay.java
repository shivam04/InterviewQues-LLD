package splitwise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ExpenseHadToPay extends BaseModel {
    @ManyToOne
    private User paidBy;
    private double amount;
    @ManyToOne
    private Expense expense;
}
