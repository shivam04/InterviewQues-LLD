package splitwise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;
import splitwise.model.constant.Currency;
import splitwise.model.constant.ExpenseStatus;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Expense extends BaseModel {
    private double amount;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private ExpenseStatus expenseStatus;
    @ManyToOne
    private Currency currency;

    @OneToMany
    @ToString.Exclude
    private List<ExpenseHadToPay> expenseHadToPayList;
    @OneToMany
    @ToString.Exclude
    private List<ExpensePaidBy> expensePaidByList;
}
