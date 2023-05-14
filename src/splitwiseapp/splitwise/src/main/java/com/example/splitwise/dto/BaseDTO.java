package com.example.splitwise.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Getter
@SuperBuilder
public class BaseDTO {
    Long id;
    Date createdAt;
    Date updatedAt;
}
