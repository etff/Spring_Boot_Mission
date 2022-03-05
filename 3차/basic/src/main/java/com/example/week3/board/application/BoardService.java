package com.example.week3.board.application;

import com.example.week3.board.domain.BoardEntity;
import com.example.week3.board.domain.BoardRepository;
import com.example.week3.board.dto.BoardRequest;
import com.example.week3.board.dto.BoardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponse getBoard(Long id) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new BoardResponse(board);
    }

    public List<BoardResponse> getBoards() {
        List<BoardEntity> foundBoards = boardRepository.findAll();
        return foundBoards.stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());
    }

    public BoardResponse createBoard(BoardRequest boardRequest) {
        String boardName = boardRequest.getBoardName();
        BoardEntity boardEntity = new BoardEntity(boardName);

        BoardEntity saved = boardRepository.save(boardEntity);
        return new BoardResponse(saved);
    }

    public BoardResponse changeBoard(Long id, BoardRequest boardRequest) {
        BoardEntity foundBoard = boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        String boardName = boardRequest.getBoardName();
        foundBoard.changeName(boardName);

        return new BoardResponse(foundBoard);
    }

    public BoardResponse deleteBoard(Long id) {
        BoardEntity foundBoard = boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        boardRepository.delete(foundBoard);

        return new BoardResponse(id);
    }
}
