package com.example.photogram.controller;

import com.example.photogram.model.Post;
import com.example.photogram.model.User;
import com.example.photogram.service.PostService;
import com.example.photogram.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/{id}/home")
    public String home(@PathVariable long id, Model model) {
        return "main";
    }

    @GetMapping("/{id}/activity")
    public String activity(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.readById(id));
        return "activity";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable long id,
                       Model model,
                       @AuthenticationPrincipal User currentUser
                       ) {
        User user = userService.readById(id);
        List<Post> posts = postService.getPostsByUserId(id);

        model.addAttribute("user", user);
        model.addAttribute("posts", posts);
        model.addAttribute("isFollower", user.getFollowers().contains(currentUser));
        model.addAttribute("numberOfPosts", posts.size());
        model.addAttribute("followers", user.getFollowers().size());
        model.addAttribute("following", user.getFollowing().size());
        model.addAttribute("isCurrentUser", user.equals(currentUser));

        return "user-page";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.readById(id));
        return "update-user";
    }

    @PostMapping("/{id}/update")
    public String update(@RequestParam("userId") User user,
                         @RequestParam String username,
                         @RequestParam String email) {

        user.setName(username);
        user.setEmail(email);
        User updatedUser = userService.update(user);
        return "redirect:/user/" + updatedUser.getId();
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "main";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user-list";
    }

    @GetMapping("/{action}/{user}")
    public String unfollow(@PathVariable User user,
                           @PathVariable String action,
                           @AuthenticationPrincipal User currentUser) {

        if (action.equals("follow")) {
            userService.follow(currentUser, user);
        } else if (action.equals("unfollow")) {
            userService.unfollow(currentUser, user);
        } else {
            //todo: 404-page.
        }
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/{type}/{user}/list")
    public String usersList(Model model,
                            @PathVariable User user,
                            @PathVariable String type) {

        model.addAttribute("profile", user);
        model.addAttribute("type", type);

        if (type.equals("followers")) {
            model.addAttribute("users", user.getFollowers());
        } else {
            model.addAttribute("users", user.getFollowing());
        }
        return "follow";
    }
}
