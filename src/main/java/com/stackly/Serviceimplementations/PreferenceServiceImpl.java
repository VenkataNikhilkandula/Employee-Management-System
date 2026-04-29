package com.stackly.Serviceimplementations;

import org.springframework.stereotype.Service;

import com.stackly.DTO.PreferenceDTO;
import com.stackly.Entities.NotificationPreference;
import com.stackly.Repository.PreferenceRepository;
import com.stackly.service.PreferenceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository repo;

    @Override
    public NotificationPreference update(Long userId, PreferenceDTO dto) {

        NotificationPreference pref = repo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Preference not found"));

        pref.setEmailEnabled(dto.isEmailEnabled());
        pref.setSmsEnabled(dto.isSmsEnabled());
        pref.setPushEnabled(dto.isPushEnabled());

        return repo.save(pref);
    }

    @Override
    public NotificationPreference get(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Preference not found"));
    }
}