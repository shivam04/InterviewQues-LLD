package com.example.splitwise.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.util.ProxyUtils;

import jakarta.persistence.Entity;
import java.util.Objects;

@Getter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Entity
public class User extends BaseModel {
    private String name;
    private String emailId;
    private String hashPassword;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
