package com.example.week3.post.infra;

import com.example.week3.post.domain.PostEntity;
import com.example.week3.post.domain.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaPostRepository extends PostRepository, CrudRepository<PostEntity, Long> {

    List<PostEntity> findAll();

    Optional<PostEntity> findById(Long id);

    PostEntity save(PostEntity postEntity);

    void delete(PostEntity postEntity);

    Page<PostEntity> findAll(Pageable pageable);

    void deleteById(Long id);
}
