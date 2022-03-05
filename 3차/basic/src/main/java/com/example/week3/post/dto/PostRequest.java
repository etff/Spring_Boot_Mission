package com.example.week3.post.dto;

import com.example.week3.post.domain.PostEntity;

public class PostRequest {
    private Long userId;
    private String title;
    private String content;
    private String password;

    public PostRequest() {
    }

    public PostRequest(Long userId, String title, String content, String password) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public PostEntity getPost() {
        return new PostEntity(this.title, this.content, this.password);
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }
}
