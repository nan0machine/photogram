package com.example.photogram.controller;

import com.example.photogram.model.Role;
import com.example.photogram.model.User;
import com.example.photogram.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String registration(@RequestParam String username,
                                @RequestParam String email,
                                @RequestParam String password) {
        User user= new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);

        user = userService.create(user);

        return "redirect:/user/" + user.getId();
    }
}
