package com.example.photogram.controller;

import com.example.photogram.model.Post;
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
    public String home(Model model) {

        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "main";
    }
}
