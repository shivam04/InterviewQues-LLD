package com.example.splitwise.dto.request;

import lombok.Value;

@Value
public class CreateUserRequest {
    String name;
    String emailId;
    String hashPassword;
    String phoneNumber;
}
