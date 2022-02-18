package com.example.mission21.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryInMemory implements PostRepository {
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryInMemory.class);
    private List<Post> postList = new ArrayList<>();

    @Override
    public List<Post> findByAll() {
        return this.postList;
    }

    @Override
    public Post findById(int id) {
        return this.postList.get(id);
    }

    @Override
    public boolean save(Post dto) {
        return this.postList.add(dto);
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, Post dto) {
        Post targetPost = this.postList.get(id);
        if (targetPost.getTitle() != null) {
            targetPost.setTitle(dto.getTitle());
        }
        if (targetPost.getContent() != null) {
            targetPost.setContent(dto.getContent());
        }
        this.postList.set(id, targetPost);
        return true;
    }
}
