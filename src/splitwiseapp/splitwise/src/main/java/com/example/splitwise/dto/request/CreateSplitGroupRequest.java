package com.example.splitwise.dto.request;

import lombok.Value;

import java.util.List;

@Value
public class CreateSplitGroupRequest {
    String name;
    String description;
    Long createdBy;
    List<Long> users;
    List<Long> adminUsers;
}
