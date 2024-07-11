package com.galu.trailflix.controllers;

import com.galu.trailflix.model.User;
import com.galu.trailflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        var maybeUser = userService.getByIdUser(id);
        return maybeUser.map(user ->
                new ResponseEntity(user, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity("User not found", HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
