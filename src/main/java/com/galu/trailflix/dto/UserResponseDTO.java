package com.galu.trailflix.dto;

import com.galu.trailflix.model.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String lastname,
        LocalDate birthDate,
        LocalDateTime registerDate,
        LocalDateTime lastUpdate
) {}
