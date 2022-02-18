package com.example.mission21.board;

import com.example.mission21.post.Post;
import com.example.mission21.post.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

@Repository
public class BoardRepositoryInMemory implements BoardRepository {
    private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryInMemory.class);
    private List<BoardDto> boardList = new ArrayList<>();

    @Override
    public List<BoardDto> findByAll() {
        return this.boardList;
    }

    @Override
    public BoardDto findById(int id) {
        return this.boardList.stream()
                .filter(it-> it.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean save(BoardDto dto) {
        dto.setId(nextId());
        return this.boardList.add(dto);
    }

    @Override
    public boolean delete(int id) {
        BoardDto boardDto = this.boardList.stream()
                .filter(it-> it.getId() == id)
                .findFirst()
                .orElse(null);
        this.boardList.remove(boardDto);
        return true;
    }

    @Override
    public boolean update(int id, BoardDto dto) {
        BoardDto targetBoard = this.boardList.stream()
                .filter(it-> it.getId() == id)
                .findFirst()
                .orElse(null);
        if (targetBoard.getBoardName() != null) {
            targetBoard.setBoardName(dto.getBoardName());
        }
        return true;
    }

    private Integer nextId() {
        OptionalInt maxOpt = boardList.stream().mapToInt(BoardDto::getId).max();
        return maxOpt.orElse(0) + 1;
    }
}
