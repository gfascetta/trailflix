package com.galu.trailflix.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String firstName,
        String lastname,
        String username,
        LocalDate birthDate,
        LocalDateTime registerDate,
        LocalDateTime lastUpdate
) {}
