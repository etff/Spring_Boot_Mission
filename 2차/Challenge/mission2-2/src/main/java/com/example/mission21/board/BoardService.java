package com.example.mission21.board;

import com.example.mission21.post.Post;

import java.util.List;

public interface BoardService {
    void createBoard(BoardDto dto);
    List<BoardDto> readBoardAll();
    BoardDto readBoard(int id);
    void updateBoard(int id, BoardDto dto);
    void deleteBoard(int id);

    void createPost(int id, Post post);

    Post readPost(int id, int postId);

    void updatePost(int id, int postId, Post post);

    void deletePost(int id, int postId, Post post);
}
