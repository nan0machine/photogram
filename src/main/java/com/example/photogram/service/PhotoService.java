package com.example.photogram.service;

import com.example.photogram.model.Photo;

public interface PhotoService {
    Photo create(Photo photo);
    void delete(long id);
    Photo readById(long id);
}
