package com.stackly.service;

import com.stackly.DTO.PreferenceDTO;
import com.stackly.Entities.NotificationPreference;

public interface PreferenceService {
    NotificationPreference update(Long userId, PreferenceDTO dto);
    NotificationPreference get(Long userId);
}