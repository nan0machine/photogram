package com.example.photogram.controller;

import com.example.photogram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String home(Model model) {

        model.addAttribute("posts", postRepository.findAll());
        return "main";
    }
}
