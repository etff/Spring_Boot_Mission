package com.example.mission21.board;

import com.example.mission21.post.Post;
import com.example.mission21.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSimpleService implements BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardSimpleService.class);
    private final BoardRepository boardRepository;
    private final PostService postService;

    public BoardSimpleService(@Autowired BoardRepository boardRepository, @Autowired PostService postService) {
        this.boardRepository = boardRepository;
        this.postService = postService;
    }

    @Override
    public void createBoard(BoardDto dto) {
        if (!this.boardRepository.save(dto)) {
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<BoardDto> readBoardAll() {
        return boardRepository.findByAll();
    }

    @Override
    public BoardDto readBoard(int id) {
        return boardRepository.findById(id);
    }

    @Override
    public void updateBoard(int id, BoardDto dto) {
        this.boardRepository.update(id, dto);
    }

    @Override
    public void deleteBoard(int id) {
        this.boardRepository.delete(id);
    }

    @Override
    public void createPost(int id, Post post) {
        BoardDto board = boardRepository.findById(id);
        int postId = postService.createPost(post);

        if (board != null) {
            board.getPostIds().add(postId);
        }
    }

    @Override
    public Post readPost(int id, int postId) {
        BoardDto board = boardRepository.findById(id);
        if (board != null) {
            Integer targetPostId = board.getPostIds().get(postId);
            return postService.readPost(targetPostId);
        }
        return null;
    }

    @Override
    public void updatePost(int id, int postId, Post post) {
        BoardDto board = boardRepository.findById(id);
        if (board != null) {
            Integer targetPostId = board.getPostIds().get(postId);
            postService.updatePost(targetPostId, post);
        }
    }

    @Override
    public void deletePost(int id, int postId, Post post) {
        BoardDto board = boardRepository.findById(id);
        if (board != null) {
            Integer targetPostId = board.getPostIds().get(postId);
            if (post.getPassword() != null) {
                postService.deletePost(targetPostId);
            }
        }
    }
}
