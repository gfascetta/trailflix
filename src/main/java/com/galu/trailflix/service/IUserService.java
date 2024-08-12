package com.galu.trailflix.service;

import com.galu.trailflix.model.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
