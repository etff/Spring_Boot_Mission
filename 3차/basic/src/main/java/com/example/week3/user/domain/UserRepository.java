package com.example.week3.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity userEntity);

    void delete(UserEntity userEntity);
}
