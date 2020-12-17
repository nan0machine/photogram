package com.example.photogram.controller;

import com.example.photogram.model.Role;
import com.example.photogram.model.User;
import com.example.photogram.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String registration(@Valid @ModelAttribute User user,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            return "registration";
        } else {
            user.setRole(Role.USER);
            user = userService.create(user);
            return "redirect:/user/" + user.getId();
        }
    }
}
