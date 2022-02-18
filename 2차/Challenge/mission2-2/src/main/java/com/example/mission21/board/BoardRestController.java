package com.example.mission21.board;

import com.example.mission21.post.Post;
import com.example.mission21.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final BoardService boardService;

    public BoardRestController(@Autowired BoardService boardService) {
        this.boardService = boardService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createBoard(@RequestBody BoardDto board) {
        logger.info(board.toString());
        this.boardService.createBoard(board);
    }

    @GetMapping()
    public List<BoardDto> readBoard() {
        logger.info("in read all");
        return this.boardService.readBoardAll();
    }

    @GetMapping("{id}")
    public BoardDto readBoardOne(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.boardService.readBoard(id);
    }

    @PutMapping("{id}")
    public void updateBoard(
            @RequestBody BoardDto boardDto,
            @PathVariable("id") int id) {
        logger.info("target id: " + id);
        logger.info("update name" + boardDto.getBoardName());
        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable("id") int id) {
        this.boardService.deleteBoard(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/post")
    public void createBoardPost(@PathVariable("id") int id, Post post) {
        this.boardService.createPost(id, post);
    }

    @GetMapping("/{id}/post/{postId}")
    public Post readBoardPost(@PathVariable("id") int id, @PathVariable("postId") int postId) {
        logger.info("in read one");
        return this.boardService.readPost(id, postId);
    }

    @PostMapping("/{id}/post/{postId}")
    public void updateBoardPost(
            @PathVariable("id") int id,
            @PathVariable("postId") int postId,
            @RequestBody Post post
    ) {
        logger.info("target id: " + id);
        logger.info("update content" + post);
        this.boardService.updatePost(id, postId, post);
    }

    @DeleteMapping("/{id}/post/{postId}")
    public void deleteBoardPost(@PathVariable("id") int id,
                           @PathVariable("postId") int postId,
                           @RequestBody Post post
    ) {
        this.boardService.deletePost(id, postId, post);
    }
}
