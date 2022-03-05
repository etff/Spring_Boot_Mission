package com.example.week3.post.domain;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<PostEntity> findAll();

    Optional<PostEntity> findById(Long id);

    PostEntity save(PostEntity postEntity);

    void delete(PostEntity postEntity);

    void deleteById(Long id);

    Page<PostEntity> findAll(Pageable pageable);
}
