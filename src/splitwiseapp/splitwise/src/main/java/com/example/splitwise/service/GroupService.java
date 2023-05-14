package com.example.splitwise.service;

import com.example.splitwise.dto.request.CreateSplitGroupRequest;
import com.example.splitwise.model.SplitGroup;
import com.example.splitwise.model.User;
import com.example.splitwise.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserService userService;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserService userService) {
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    public SplitGroup createGroup(CreateSplitGroupRequest createSplitGroupRequest) throws IllegalAccessException {
        Long createdByUserId = createSplitGroupRequest.getCreatedBy();
        List<Long> userIds = createSplitGroupRequest.getUsers();
        List<Long> adminUserIds = createSplitGroupRequest.getAdminUsers();
        User createdByUser = User.builder().id(createdByUserId).build();
        List<User> users = userIds.stream()
                .map(id -> User.builder().id(id).build())
                .collect(Collectors.toList());
        List<User> adminusers = adminUserIds.stream()
                .map(id -> User.builder().id(id).build())
                .collect(Collectors.toList());

        SplitGroup splitGroup = SplitGroup
                .builder()
                .name(createSplitGroupRequest.getName())
                .description(createSplitGroupRequest.getDescription())
                .createdBy(createdByUser)
                .users(users)
                .adminUsers(adminusers)
                .build();
        return groupRepository.save(splitGroup);
    }

    public SplitGroup getGroup(Long id) throws IllegalAccessException {
        Optional<SplitGroup> splitGroup = groupRepository.findById(id);
        if (splitGroup.isEmpty()) {
            throw new IllegalAccessException(String.format("Group with Id: [%s] Not Found", id));
        }
        return splitGroup.get();
    }
}
