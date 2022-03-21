package com.example.mission4.dto;

import com.example.mission4.entity.UserEntity;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Boolean isShopOwner;

    public UserDto() {
    }

    public UserDto(UserEntity userEntity){
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.isShopOwner = userEntity.getShopOwner();
    }

    public UserDto(Long id, String username, String password, Boolean isShopOwner) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isShopOwner = isShopOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsShopOwner() {
        return isShopOwner;
    }

    public void setIsShopOwner(Boolean shopOwner) {
        isShopOwner = shopOwner;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isShopOwner=" + isShopOwner +
                '}';
    }
}
