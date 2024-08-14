package com.galu.trailflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public record UserCreateRequestDTO(
        @NotBlank(message = "Please provide a firstname")
        @Size(min = 4, max = 20)
        String firstName,
        @NotBlank(message = "Please provide a lastname")
        @Size(min = 4, max = 20)
        String lastname,
        @Past
        LocalDate birthDate,
        @NotBlank(message = "Username is mandatory")
        @Size(min = 4, max = 40)
        String username,
        @NotBlank(message = "Password is mandatory")
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$",
                message = "Password must include characters in lowercase, uppercase, at least a number and a special character from: #?!@$%^&*-")
        @Size(min = 8, max = 16, message = "password must be between 8 and 16 characters long")
        String password

) {}