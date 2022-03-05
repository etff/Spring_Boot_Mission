package com.example.week3.board.domain;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<BoardEntity> findAll();

    Optional<BoardEntity> findById(Long id);

    BoardEntity save(BoardEntity boardEntity);

    void delete(BoardEntity boardEntity);
}
