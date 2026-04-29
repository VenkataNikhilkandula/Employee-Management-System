package com.stackly.service;

import java.util.List;

import com.stackly.DTO.UserDTO;
import com.stackly.Entities.User;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
}