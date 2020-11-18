package com.example.photogram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        List<String> posts = Stream.of("post# 1", "post# 2", "post# 3").collect(Collectors.toList());
        model.addAttribute("posts",posts);
        return "home";
    }
}
