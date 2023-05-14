package com.example.splitwise.controller;

import com.example.splitwise.dto.reponse.GetUserResponse;
import com.example.splitwise.dto.request.CreateUserRequest;
import com.example.splitwise.dto.reponse.CreateUserResponse;
import com.example.splitwise.model.User;
import com.example.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("user")
public class UserController {
    private final com.example.splitwise.service.UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        User savedUser = userService.createUser(createUserRequest);
        return CreateUserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .phoneNumber(savedUser.getPhoneNumber())
                .emailId(savedUser.getEmailId())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public GetUserResponse getUser(@PathVariable("id") Long id) throws IllegalAccessException {
        User user = userService.getUser(id);
        return GetUserResponse.builder()
                .name(user.getName())
                .emailId(user.getEmailId())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
