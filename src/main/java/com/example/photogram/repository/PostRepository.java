package com.example.photogram.repository;

import com.example.photogram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByOwner_Id(Long ownerId);
}
