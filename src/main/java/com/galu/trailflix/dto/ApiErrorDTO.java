package com.galu.trailflix.dto;

import org.springframework.http.HttpStatus;

public record ApiErrorDTO(
        HttpStatus httpStatus,
        String message
) {
}
