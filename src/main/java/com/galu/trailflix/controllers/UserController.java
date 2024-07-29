package com.galu.trailflix.controllers;

import com.galu.trailflix.dto.UserResponseDTO;
import com.galu.trailflix.model.User;
import com.galu.trailflix.service.UserService;
import com.galu.trailflix.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("User created", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        var maybeUser = userService.getByIdUser(id);
        if (maybeUser.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(UserTranslator.mapToUserResponseDTO(maybeUser.get()), HttpStatus.OK);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return UserTranslator.mapToListUserResponseDTO(userService.getAllUsers());
    }
}
