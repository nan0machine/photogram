package com.example.photogram.service;

import com.example.photogram.model.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    Post create(Post post, MultipartFile file);
    Post update(Post post);
    void delete(long id);
    Post readById(long id);
    List<Post> getAll();
    List<Post> getPostsByUserId(long userId);
}
