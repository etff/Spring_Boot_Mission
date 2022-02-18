package com.example.mission21.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSimpleService implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostSimpleService.class);
    private final PostRepository postRepository;

    public PostSimpleService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public int createPost(Post dto) {
        if (!this.postRepository.save(dto)) {
            throw new RuntimeException("save failed");
        }
        return postRepository.findByAll().size();
    }

    @Override
    public List<Post> readPostAll() {
        return null;
    }

    @Override
    public Post readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, Post dto) {
        this.postRepository.update(id, dto);
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
