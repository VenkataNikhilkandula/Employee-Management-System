package com.stackly.Serviceimplementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackly.DTO.NotificationRequestDTO;
import com.stackly.Entities.Notification;
import com.stackly.Entities.NotificationPreference;
import com.stackly.Entities.User;
import com.stackly.Enums.NotificationChannel;
import com.stackly.Enums.NotificationStatus;
import com.stackly.Repository.NotificationRepository;
import com.stackly.Repository.PreferenceRepository;
import com.stackly.Repository.UserRepository;
import com.stackly.service.NotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final UserRepository userRepo;
    private final PreferenceRepository prefRepo;
    private final NotificationRepository notifRepo;

    @Override
    public void send(NotificationRequestDTO dto) {

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        NotificationPreference pref = prefRepo.findByUserId(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Preference not found"));

        boolean enabled = switch (dto.getChannel()) {
            case EMAIL -> pref.isEmailEnabled();
            case SMS -> pref.isSmsEnabled();
            case PUSH -> pref.isPushEnabled();
        };

        NotificationStatus status = enabled ? NotificationStatus.SENT : NotificationStatus.FAILED;

        Notification notification = Notification.builder()
                .user(user)
                .channel(dto.getChannel())
                .message(dto.getMessage())
                .status(status)
                .build();

        notifRepo.save(notification);
    }

    @Override
    public List<Notification> getByUser(Long userId) {
        return notifRepo.findByUserId(userId);
    }

    @Override
    public List<Notification> getByStatus(NotificationStatus status) {
        return notifRepo.findByStatus(status);
    }

    @Override
    public List<Notification> getByChannel(NotificationChannel channel) {
        return notifRepo.findByChannel(channel);
    }
}