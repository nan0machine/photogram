package com.example.photogram.service;

import com.example.photogram.model.Photo;

import java.util.List;

public interface PhotoService {
    Photo create(Photo photo);
    void delete(long id);
    Photo readById(long id);
    List<Photo> getPhotosByPostId(long postId);
}
