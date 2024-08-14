package com.galu.trailflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public record UserCreateRequestDTO(
        @NotBlank(message = "Firstname is mandatory")
        @Size(max = 120, message = "firstname must be under 120 characters long")
        String firstName,
        @NotBlank(message = "Lastname is mandatory")
        @Size(max = 120, message = "lastname must be under 120 characters long")
        String lastname,
        @Past(message = "birthdate invalid")
        LocalDate birthDate,
        @NotBlank(message = "Username is mandatory")
        @Size(min = 4, max = 40)
        String username,
        @NotBlank(message = "Password is mandatory")
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$",
                message = "Password must include characters in lowercase, uppercase, at least" +
                        " a number and a special character from: #?!@$%^&*- and must be" +
                        " between 8 and 16 characters long")
        String password

) {}