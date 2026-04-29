package com.stackly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.DTO.PreferenceDTO;
import com.stackly.Entities.NotificationPreference;
import com.stackly.service.PreferenceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/preferences")
@RequiredArgsConstructor
public class PreferenceController {
    @Autowired
    private PreferenceService service;

    @PutMapping("/{userId}")
    public NotificationPreference update(@PathVariable Long userId,
                                         @RequestBody PreferenceDTO dto) {
        return service.update(userId, dto);
    }

    @GetMapping("/{userId}")
    public NotificationPreference get(@PathVariable Long userId) {
        return service.get(userId);
    }
}