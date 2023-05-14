package com.example.splitwise.model;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class ExpensePaidBy extends BaseModel {
    @ManyToOne
    private User paidBy;
    private double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        ExpensePaidBy that = (ExpensePaidBy) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }
    @ManyToOne
    private Expense expense;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
