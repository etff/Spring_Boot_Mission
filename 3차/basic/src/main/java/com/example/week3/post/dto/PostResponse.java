package com.example.week3.post.dto;

import com.example.week3.post.domain.PostEntity;
import com.example.week3.user.domain.UserEntity;

import java.util.Objects;

public class PostResponse {
    private Long id;
    private String title;
    private String content;

    private UserEntity user;

    public PostResponse() {
    }

    public PostResponse(Long id, String title, String content, UserEntity user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public PostResponse(PostEntity post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.user = post.getWriter();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostResponse)) return false;
        PostResponse that = (PostResponse) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
