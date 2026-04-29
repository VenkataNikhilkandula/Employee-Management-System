package com.stackly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.DTO.NotificationRequestDTO;
import com.stackly.Entities.Notification;
import com.stackly.Enums.NotificationChannel;
import com.stackly.Enums.NotificationStatus;
import com.stackly.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    @Autowired
    private  NotificationService service;

    @PostMapping("/send")
    public String send(@RequestBody NotificationRequestDTO dto) {
        service.send(dto);
        return "Notification processed";
    }

    @GetMapping("/user/{userId}")
    public List<Notification> byUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @GetMapping("/status/{status}")
    public List<Notification> byStatus(@PathVariable NotificationStatus status) {
        return service.getByStatus(status);
    }

    @GetMapping("/channel/{channel}")
    public List<Notification> byChannel(@PathVariable NotificationChannel channel) {
        return service.getByChannel(channel);
    }
}