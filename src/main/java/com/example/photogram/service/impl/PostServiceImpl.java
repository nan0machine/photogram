package com.example.photogram.service.impl;

import com.example.photogram.model.Post;
import com.example.photogram.repository.PostRepository;
import com.example.photogram.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Post update(Post post) {
        //ToDO: add post check
        return postRepository.saveAndFlush(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post readById(long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
