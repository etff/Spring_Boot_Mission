package com.example.mission21.board;

import com.example.mission21.post.Post;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {
    private int id;
    private String boardName;

    private List<Integer> postIds = new ArrayList<>();

    public BoardDto() {
    }

    public BoardDto(String boardName) {
        this.boardName = boardName;
        this.postIds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<Integer> getPostIds() {
        return postIds;
    }
}
