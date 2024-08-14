package com.galu.trailflix.service;

import com.galu.trailflix.model.User;
import com.galu.trailflix.model.exception.UserAlreadyExistException;
import com.galu.trailflix.model.exception.UserNotExistException;
import com.galu.trailflix.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException(user.getUsername());
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotExistException(id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
