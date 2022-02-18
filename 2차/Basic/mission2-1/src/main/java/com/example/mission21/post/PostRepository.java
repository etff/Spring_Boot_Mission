package com.example.mission21.post;

import java.util.List;

public interface PostRepository {
    List<Post> findByAll();
    Post findById(int id);
    boolean save(Post dto);
    boolean delete(int id);
    boolean update(int id, Post dto);
}
