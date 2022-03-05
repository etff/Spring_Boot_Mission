package com.example.week3.board.dto;

public class BoardRequest {
    private String boardName;

    public BoardRequest(String boardName) {
        this.boardName = boardName;
    }

    public BoardRequest() {
    }

    public String getBoardName() {
        return boardName;
    }
}
