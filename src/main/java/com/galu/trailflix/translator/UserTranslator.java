package com.galu.trailflix.translator;

import com.galu.trailflix.dto.UserResponseDTO;
import com.galu.trailflix.model.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserTranslator {

    static UserResponseDTO mapToUserResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getLastname(), user.getBirthDate(), user.getRegisterDate(), user.getLastUpdate());
    }

    static List<UserResponseDTO> mapToListUserResponseDTO (List<User> users){
        return users.stream().map(UserTranslator::mapToUserResponseDTO)
                .collect(Collectors.toList());
    }
}
