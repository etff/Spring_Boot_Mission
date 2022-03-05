package com.example.week3.board.dto;

import com.example.week3.board.domain.BoardEntity;

public class BoardResponse {
    private Long id;
    private String boardName;

    public BoardResponse() {
    }

    public BoardResponse(Long id) {
        this.id = id;
        this.boardName = null;
    }

    public BoardResponse(Long id, String boardName) {
        this.id = id;
        this.boardName = boardName;
    }

    public BoardResponse(BoardEntity board) {
        this.id = board.getId();
        this.boardName = board.getBoardName();
    }

    public Long getId() {
        return id;
    }

    public String getBoardName() {
        return boardName;
    }
}
