package com.stackly.service;

import java.util.List;

import com.stackly.DTO.NotificationRequestDTO;
import com.stackly.Entities.Notification;
import com.stackly.Enums.NotificationChannel;
import com.stackly.Enums.NotificationStatus;

public interface NotificationService {
    void send(NotificationRequestDTO dto);
    List<Notification> getByUser(Long userId);
    List<Notification> getByStatus(NotificationStatus status);
    List<Notification> getByChannel(NotificationChannel channel);
}