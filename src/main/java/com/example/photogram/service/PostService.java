package com.example.photogram.service;

import com.example.photogram.model.Post;

import java.util.List;

public interface PostService {
    Post create(Post post);
    Post update(Post post);
    void delete(long id);
    Post readById(long id);
    List<Post> getAll();
}
