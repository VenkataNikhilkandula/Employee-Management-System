package com.stackly.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.Entities.NotificationPreference;

public interface PreferenceRepository extends JpaRepository<NotificationPreference, Long> {
    Optional<NotificationPreference> findByUserId(Long userId);
}