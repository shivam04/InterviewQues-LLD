package com.example.splitwise.model;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class SplitGroup extends BaseModel {
    private String name;
    private String description;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    @ToString.Exclude
    private List<User> adminUsers;
    @ManyToMany
    @ToString.Exclude
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        SplitGroup group = (SplitGroup) o;
        return getId() != null && Objects.equals(getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
