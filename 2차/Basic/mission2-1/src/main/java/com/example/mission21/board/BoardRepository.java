package com.example.mission21.board;

import java.util.List;

public interface BoardRepository {
    List<BoardDto> findByAll();
    BoardDto findById(int id);
    boolean save(BoardDto dto);
    boolean delete(int id);
    boolean update(int id, BoardDto dto);
}
