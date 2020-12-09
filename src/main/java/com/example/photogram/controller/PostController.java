package com.example.photogram.controller;

import com.example.photogram.model.Post;
import com.example.photogram.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("post") Post post) {
       Post newPost = postService.create(post);
       return "redirect:/post/" + newPost.getId();
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.readById(id));
        return "update_post";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, @ModelAttribute("post") Post post, Model model) {
        long postId = postService.update(post).getId();
        return "redirect:/post/" + postId;
    }

    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.readById(id));
        return "post_page";
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
        return "posts_list";
    }
}
