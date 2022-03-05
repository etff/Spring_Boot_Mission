package com.example.week3.board.application;

import com.example.week3.board.dto.BoardRequest;
import com.example.week3.board.dto.BoardResponse;
import com.example.week3.board.infra.JpaBoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Transactional
class BoardServiceTest {

    @Autowired
    private JpaBoardRepository boardRepository;

    private BoardService boardService;

    @BeforeEach
    void setUp() {
        boardService = new BoardService(boardRepository);
    }

    @Test
    void create() {
        String boardName = "운동";
        BoardRequest boardRequest = new BoardRequest(boardName);

        BoardResponse actual = boardService.createBoard(boardRequest);

        assertThat(actual.getBoardName()).isEqualTo(boardName);
    }

    @Test
    void get_board() {
        String boardName = "운동";
        BoardRequest boardRequest = new BoardRequest(boardName);
        BoardResponse board = boardService.createBoard(boardRequest);

        BoardResponse actual = boardService.getBoard(board.getId());

        assertThat(actual).isNotNull();
    }

    @Test
    void get_board_list() {
        BoardRequest boardRequest1 = new BoardRequest("운동");
        BoardRequest boardRequest2 = new BoardRequest("음식");
        boardService.createBoard(boardRequest1);
        boardService.createBoard(boardRequest2);

        List<BoardResponse> actual = boardService.getBoards();

        assertThat(actual.isEmpty()).isFalse();
    }

    @Test
    void change_board() {
        String boardName = "운동";
        String boardName2 = "쉬기";
        BoardRequest boardRequest = new BoardRequest(boardName);
        BoardRequest boardRequest2 = new BoardRequest(boardName2);
        BoardResponse board = boardService.createBoard(boardRequest);

        BoardResponse boardResponse = boardService.changeBoard(board.getId(), boardRequest2);

        assertThat(boardResponse.getBoardName()).isEqualTo(boardName2);
    }

    @Test
    void delete_board() {
        String boardName = "운동";
        BoardRequest boardRequest = new BoardRequest(boardName);
        BoardResponse board = boardService.createBoard(boardRequest);

        boardService.deleteBoard(board.getId());

        assertThatThrownBy(() -> {
            boardService.getBoard(board.getId());
        }).isInstanceOf(EntityNotFoundException.class);
    }
}
