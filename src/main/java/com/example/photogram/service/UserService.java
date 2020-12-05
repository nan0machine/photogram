package com.example.photogram.service;

import com.example.photogram.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user);
    void delete(long id);
    User readById(long id);
    List<User> getAll();
}
