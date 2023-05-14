package com.example.splitwise.service;

import com.example.splitwise.dto.request.CreateUserRequest;
import com.example.splitwise.model.User;
import com.example.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .name(createUserRequest.getName())
                .emailId(createUserRequest.getEmailId())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .hashPassword(createUserRequest.getHashPassword())
                .build();
        return userRepository.save(user);
    }

    public User getUser(Long id) throws IllegalAccessException {
        Optional<User> user =  userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalAccessException(String.format("User with Id: [%s] Not Found", id));
        }
        return user.get();
    }

    public List<User> getUsers(List<Long> userIds) {
        return userRepository.findAllById(userIds);
    }
}
