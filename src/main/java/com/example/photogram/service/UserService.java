package com.example.photogram.service;

import com.example.photogram.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User create(User user);
    User update(User user);
    void delete(long id);
    User readById(long id);
    List<User> getAll();
}
