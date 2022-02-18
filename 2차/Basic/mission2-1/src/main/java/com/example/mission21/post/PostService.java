package com.example.mission21.post;

import java.util.List;

public interface PostService {
    int createPost(Post dto);
    List<Post> readPostAll();
    Post readPost(int id);
    void updatePost(int id, Post dto);
    void deletePost(int id);
}
