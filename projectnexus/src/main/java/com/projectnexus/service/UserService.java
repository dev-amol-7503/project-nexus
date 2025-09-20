package com.projectnexus.service;

import com.projectnexus.model.User;
import com.projectnexus.dto.UserDto;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User userDetails);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User changeUserStatus(Long userId, User.UserStatus status);
    UserDto getCurrentUser(String username);
}