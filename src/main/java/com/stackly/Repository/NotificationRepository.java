package com.stackly.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.Entities.Notification;
import com.stackly.Enums.NotificationChannel;
import com.stackly.Enums.NotificationStatus;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserId(Long userId);

    List<Notification> findByStatus(NotificationStatus status);

    List<Notification> findByChannel(NotificationChannel channel);
}