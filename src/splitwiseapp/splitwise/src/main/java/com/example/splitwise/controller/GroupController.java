package com.example.splitwise.controller;

import com.example.splitwise.dto.reponse.CreateSplitGroupResponse;
import com.example.splitwise.dto.reponse.GetSplitGroupResponse;
import com.example.splitwise.dto.request.CreateSplitGroupRequest;
import com.example.splitwise.model.SplitGroup;
import com.example.splitwise.model.User;
import com.example.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public CreateSplitGroupResponse createGroup(@RequestBody CreateSplitGroupRequest createSplitGroupRequest)
            throws IllegalAccessException {
        SplitGroup splitGroup = groupService.createGroup(createSplitGroupRequest);
        return CreateSplitGroupResponse.builder()
                .id(splitGroup.getId())
                .name(splitGroup.getName())
                .description(splitGroup.getDescription())
                .createdBy(splitGroup.getCreatedBy().getId())
                .users(splitGroup.getUsers().stream().map(User::getId).collect(Collectors.toList()))
                .adminUsers(splitGroup.getAdminUsers().stream().map(User::getId).collect(Collectors.toList()))
                .createdAt(splitGroup.getCreatedAt())
                .updatedAt(splitGroup.getUpdatedAt())
                .build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public GetSplitGroupResponse getGroup(@PathVariable("id") Long id) {
        return null;
    }
}
