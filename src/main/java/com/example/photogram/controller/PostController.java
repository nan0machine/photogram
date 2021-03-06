package com.example.photogram.controller;

import com.example.photogram.model.Post;
import com.example.photogram.model.User;
import com.example.photogram.service.PostService;
import com.example.photogram.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/post")
public class PostController {

    private final UserService userService;
    private final PostService postService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create() {
        return "create-post";
    }

    @PostMapping("/create")
    public String create(@RequestParam("file") MultipartFile file,
                         @RequestParam String description,
                         @AuthenticationPrincipal User user,
                         Model model) {
        if (file.isEmpty()) {
            model.addAttribute("fileInvalid", "Please add a photo.");
            return "create-post";
        }

        User owner = userService.readById(user.getId());
        Post post = new Post();
        post.setDescription(description);
        post.setOwner(owner);

        post = postService.create(post, file);
        return "redirect:/post/" + post.getId();
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        Post post = postService.readById(id);
        model.addAttribute("post", post);
        return "update-post";
    }

    @PostMapping("/{id}/update")
    public String update(@AuthenticationPrincipal User user,
                         @RequestParam Post post,
                         @RequestParam String description ) {

        if (user.equals(post.getOwner())) {
            post.setDescription(description);
            post = postService.update(post);
        }
        return "redirect:/post/" + post.getId();
    }

    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.readById(id));
        return "post-page";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        long ownerId = postService.readById(id).getOwner().getId();
        postService.delete(id);
        return "redirect:/user/" + ownerId;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "posts-list";
    }
}
