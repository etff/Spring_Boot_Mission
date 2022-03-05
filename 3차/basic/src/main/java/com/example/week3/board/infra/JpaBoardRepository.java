package com.example.week3.board.infra;

import com.example.week3.board.domain.BoardEntity;
import com.example.week3.board.domain.BoardRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBoardRepository extends BoardRepository, CrudRepository<BoardEntity, Long> {
    List<BoardEntity> findAll();

    Optional<BoardEntity> findById(Long id);

    BoardEntity save(BoardEntity boardEntity);

    void delete(BoardEntity boardEntity);
}
