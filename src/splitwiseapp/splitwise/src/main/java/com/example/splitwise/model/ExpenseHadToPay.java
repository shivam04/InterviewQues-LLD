package com.example.splitwise.model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class ExpenseHadToPay extends BaseModel {
    @ManyToOne
    private User paidBy;
    private double amount;
    @ManyToOne
    private Expense expense;
}
