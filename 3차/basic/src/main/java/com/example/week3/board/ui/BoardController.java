package com.example.week3.board.ui;

import com.example.week3.board.application.BoardService;
import com.example.week3.board.dto.BoardRequest;
import com.example.week3.board.dto.BoardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable Long id) {
        BoardResponse boardResponse = boardService.getBoard(id);
        return ResponseEntity.ok().body(boardResponse);
    }

    @GetMapping("")
    public ResponseEntity<List<BoardResponse>> getBoardList() {
        List<BoardResponse> boards = boardService.getBoards();
        return ResponseEntity.ok().body(boards);
    }

    @PostMapping("")
    public ResponseEntity<BoardResponse> createBoard(@RequestBody BoardRequest boardRequest) {
        BoardResponse boardResponse = boardService.createBoard(boardRequest);
        return new ResponseEntity<>(boardResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> changeBoard(@PathVariable Long id, @RequestBody BoardRequest boardRequest) {
        BoardResponse boardResponse = boardService.changeBoard(id, boardRequest);
        return new ResponseEntity<>(boardResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
