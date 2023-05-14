package com.example.splitwise.model;

import com.example.splitwise.model.constant.Currency;
import com.example.splitwise.model.constant.ExpenseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Expense extends BaseModel {
    private double amount;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseStatus expenseStatus;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    @OneToMany
    @ToString.Exclude
    private List<ExpenseHadToPay> expenseHadToPayList;
    @OneToMany
    @ToString.Exclude
    private List<ExpensePaidBy> expensePaidByList;
}
