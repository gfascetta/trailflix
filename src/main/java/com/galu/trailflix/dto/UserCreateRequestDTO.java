package com.galu.trailflix.dto;

import java.time.LocalDate;


public record UserCreateRequestDTO(
        String firstName,
        String lastname,
        LocalDate birthDate,
        String username,
        String password
) {
    public boolean isValid() {
        return username != null && !username.isEmpty() && !username.isBlank();
    }
}