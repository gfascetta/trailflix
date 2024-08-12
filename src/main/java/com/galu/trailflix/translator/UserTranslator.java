package com.galu.trailflix.translator;

import com.galu.trailflix.dto.UserCreateRequestDTO;
import com.galu.trailflix.dto.UserResponseDTO;
import com.galu.trailflix.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public interface UserTranslator {

    static UserResponseDTO mapToUserResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastname(),
                user.getUsername(),
                user.getBirthDate(),
                user.getRegisterDate(),
                user.getLastUpdate());
    }

    static List<UserResponseDTO> mapToListUserResponseDTO (List<User> users){
        return users.stream().map(UserTranslator::mapToUserResponseDTO)
                .collect(Collectors.toList());
    }

    static User mapToNewUser(UserCreateRequestDTO dto) {
        var now = LocalDateTime.now();
        return User.builder()
                .firstName(dto.firstName())
                .lastname(dto.lastname())
                .birthDate(dto.birthDate())
                .username(dto.username())
                .password(dto.password())
                .registerDate(now)
                .lastUpdate(now)
                .build();
    }
}
