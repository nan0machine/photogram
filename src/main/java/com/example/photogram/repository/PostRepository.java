package com.example.photogram.repository;

import com.example.photogram.model.Post;
import com.example.photogram.model.User;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
