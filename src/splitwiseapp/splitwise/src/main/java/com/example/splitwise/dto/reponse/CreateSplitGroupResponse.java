package com.example.splitwise.dto.reponse;

import com.example.splitwise.dto.BaseDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class CreateSplitGroupResponse extends BaseDTO {
    String name;
    String description;
    Long createdBy;
    List<Long> users;
    List<Long> adminUsers;
}
