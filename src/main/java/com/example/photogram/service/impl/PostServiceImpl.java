package com.example.photogram.service.impl;

import com.example.photogram.exception.NullEntityReferenceException;
import com.example.photogram.model.Post;
import com.example.photogram.repository.PostRepository;
import com.example.photogram.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Value("${upload.path}")
    private String uploadPath;

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(Post post, MultipartFile file) {
        if (post != null) {

            if (file != null) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultName = uuidFile + "." + file.getOriginalFilename();

                try {
                    file.transferTo(new File(uploadPath + "/" + resultName));
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

                post.setPhotoName(resultName);
                return postRepository.saveAndFlush(post);
            }
        }
        throw new NullEntityReferenceException("Post cant be 'null'");
    }

    @Override
    public Post update(Post post) {
        if (post != null) {
            Post oldPost = readById(post.getId());
            if (oldPost != null) {
                return postRepository.saveAndFlush(post);
            }
        }
        throw new NullEntityReferenceException("Post cant be 'null'");
    }

    @Override
    public void delete(long id) {
        Post post = readById(id);
        if (post != null) {
            postRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Post with id: " + id + " not found");
    }

    @Override
    public Post readById(long id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("Post with id: " + id + " not found");
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll();
        return posts.isEmpty() ? new ArrayList<>() : posts;
    }

    @Override
    public List<Post> getPostsByUserId(long userId) {
        List<Post> posts = postRepository.findPostsByOwner_Id(userId);
        return posts.isEmpty() ? new ArrayList<>() : posts;
    }

}
