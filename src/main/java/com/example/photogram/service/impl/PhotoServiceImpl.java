package com.example.photogram.service.impl;

import com.example.photogram.exception.NullEntityReferenceException;
import com.example.photogram.model.Photo;
import com.example.photogram.repository.PhotoRepository;
import com.example.photogram.service.PhotoService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhotoServiceImpl implements PhotoService {

    final private PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo create(Photo photo) {
        if (photo != null) {
            return photoRepository.saveAndFlush(photo);
        }
        throw new NullEntityReferenceException("Photo cant be 'null'");
    }

    @Override
    public void delete(long id) {
        Photo photo = readById(id);
        if (photo != null) {
            photoRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Photo with id: " + id + " not found");
    }

    @Override
    public Photo readById(long id) {
        Optional<Photo> optional = photoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("Photo with id: " + id + " not found");
    }

    @Override
    public List<Photo> getPhotosByPostId(long postId) {
        List<Photo> photos = photoRepository.findPhotosByPostId(postId);
        return photos.isEmpty() ? new ArrayList<>() : photos;
    }
}
