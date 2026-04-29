package com.stackly.DTO;

import com.stackly.Enums.NotificationChannel;

import lombok.Data;

@Data
public class NotificationRequestDTO {
    private Long userId;
    private NotificationChannel channel;
    private String message;
}