package com.example.week3.user.dto;

public class UserResponse {
    private Long id;

    private String userId;

    private String password;

    public UserResponse() {
    }

    public UserResponse(Long id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
