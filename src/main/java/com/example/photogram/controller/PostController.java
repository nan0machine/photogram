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

    @GetMapping("/create/user/{user_id}")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/create/user/{user_id}")
    public String create(@ModelAttribute("post") Post post) {
       Post newPost = postService.create(post);
       return "redirect:/post/" + newPost.getId();
    }

    @GetMapping("/{id}/update/user/{user_id}")
    public String update(@PathVariable long id, Model model) {
        Post post = postService.readById(id);
        model.addAttribute("post", post);
        return "update-post";
    }

    @PostMapping("/{id}/update/user/{user_id}")
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

    @GetMapping("/{id}/delete/user/{user_id}")
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
