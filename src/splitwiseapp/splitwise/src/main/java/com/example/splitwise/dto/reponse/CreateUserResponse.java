package com.example.splitwise.dto.reponse;

import com.example.splitwise.dto.BaseDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
public class CreateUserResponse extends BaseDTO {
    String name;
    String emailId;
    String phoneNumber;
}
