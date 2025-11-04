package com.descomplica.BlogProject.services.impl;

import com.descomplica.BlogProject.models.User;
import com.descomplica.BlogProject.repositories.UserRepository;
import com.descomplica.BlogProject.services.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {
        User existingUser = userRepository.findByUsername(user.getName());
        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException("Username already exists");
        }
        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());

        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole());
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
