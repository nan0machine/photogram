package com.example.photogram.service.impl;

import com.example.photogram.model.Photo;
import com.example.photogram.repository.PhotoRepository;
import com.example.photogram.service.PhotoService;

public class PhotoServiceImpl implements PhotoService {

    final private PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo create(Photo photo) {
        return photoRepository.saveAndFlush(photo);
    }

    @Override
    public void delete(long id) {
        photoRepository.deleteById(id);
    }

    @Override
    public Photo readById(long id) {
        return photoRepository.findById(id).orElse(null);
    }
}
