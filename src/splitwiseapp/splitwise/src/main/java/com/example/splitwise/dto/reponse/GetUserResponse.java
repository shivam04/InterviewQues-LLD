package com.example.splitwise.dto.reponse;

import com.example.splitwise.dto.BaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public class GetUserResponse {
    String name;
    String emailId;
    String phoneNumber;
}
