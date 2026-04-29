package com.stackly.Serviceimplementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackly.DTO.UserDTO;
import com.stackly.Entities.NotificationPreference;
import com.stackly.Entities.User;
import com.stackly.Repository.PreferenceRepository;
import com.stackly.Repository.UserRepository;
import com.stackly.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final PreferenceRepository prefRepo;

    @Override
    public User createUser(User dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        User saved = userRepo.save(user);

        // Create default preference
        NotificationPreference pref = new NotificationPreference();
        pref.setUser(saved);
        prefRepo.save(pref);

        return saved;
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}