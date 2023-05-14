package com.example.splitwise.dto.reponse;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetSplitGroupResponse {
    String name;
    String description;
    Long createdBy;
    List<Long> users;
    List<Long> adminUsers;
}
