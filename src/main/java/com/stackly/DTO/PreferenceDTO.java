package com.stackly.DTO;

import lombok.Data;

@Data
public class PreferenceDTO {
    private boolean emailEnabled;
    private boolean smsEnabled;
    private boolean pushEnabled;
}