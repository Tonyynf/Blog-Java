package com.descomplica.BlogProject.services;

import com.descomplica.BlogProject.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User get(Long id);

    List<User> getAll();

    User update(Long id, User user);

    void delete(Long id);
}
