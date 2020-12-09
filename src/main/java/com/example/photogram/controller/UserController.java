package com.example.photogram.controller;

import com.example.photogram.model.User;
import com.example.photogram.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        long id = userService.create(user).getId();
        return "redirect:/user/" + id;
    }

    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "user_page";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.readById(id));
        return "update_user";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, @ModelAttribute("user") User user, Model model) {
        long userId = userService.update(user).getId();
        return "redirect:/user/" + userId;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "main";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user_list";
    }
}
