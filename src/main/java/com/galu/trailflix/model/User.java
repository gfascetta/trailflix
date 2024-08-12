package com.galu.trailflix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastname;
    @Column(unique = true, nullable = false)
    private String username;
    private String password; //  TODO: NO PUEDE SER NULL
    private LocalDate birthDate;
    private LocalDateTime registerDate; // TODO: NO PUEDE SER NULL
    private LocalDateTime lastUpdate; //  TODO: NO PUEDE SER NULL
}
