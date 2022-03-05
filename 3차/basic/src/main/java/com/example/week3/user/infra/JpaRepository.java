package com.example.week3.user.infra;

import com.example.week3.user.domain.UserEntity;
import com.example.week3.user.domain.UserRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaRepository extends UserRepository, CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity userEntity);

    void delete(UserEntity userEntity);
}
