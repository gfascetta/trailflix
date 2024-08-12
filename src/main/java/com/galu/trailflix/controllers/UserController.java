package com.galu.trailflix.controllers;

import com.galu.trailflix.dto.UserCreateRequestDTO;
import com.galu.trailflix.dto.UserResponseDTO;
import com.galu.trailflix.model.User;
import com.galu.trailflix.model.exception.RequestDTOInvalidException;
import com.galu.trailflix.service.IUserService;
import com.galu.trailflix.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequestDTO userRequestDTO) {
        if (!userRequestDTO.isValid()){
            throw new RequestDTOInvalidException(userRequestDTO.username());
        }
        var user = userService.createUser(UserTranslator.mapToNewUser(userRequestDTO));
        return new ResponseEntity<>(UserTranslator.mapToUserResponseDTO(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        var userFound = userService.getUserById(id);

        return new ResponseEntity<>(UserTranslator.mapToUserResponseDTO(userFound), HttpStatus.OK);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return UserTranslator.mapToListUserResponseDTO(userService.getAllUsers());
    }
}