package com.example.photogram.repository;

import com.example.photogram.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findPhotosByPostId(Long postId);
}
