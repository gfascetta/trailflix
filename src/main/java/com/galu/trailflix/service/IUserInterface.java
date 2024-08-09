package com.galu.trailflix.service;

import com.galu.trailflix.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserInterface {
    User createUser(User user);

    Optional<User> getByIdUser(Long id);

    List<User> getAllUsers();
}
