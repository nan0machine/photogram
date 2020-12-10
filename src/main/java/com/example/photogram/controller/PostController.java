package com.example.photogram.controller;

import com.example.photogram.model.Post;
import com.example.photogram.service.PostService;
import com.example.photogram.service.UserService;
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
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/create")
    public String create(@RequestParam("file") MultipartFile file,
                         @RequestParam String description) {

        Post post = new Post();
        post.setDescription(description);
        post.setOwner(userService.readById(1));

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
    public String update(@RequestParam("postId") Post post,
                         @RequestParam String description) {

        post.setDescription(description);
        Post updatedPost = postService.update(post);
        return "redirect:/post/" + updatedPost.getId();
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
