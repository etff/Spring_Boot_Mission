package com.example.week3.board.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardEntityTest {

    @Test
    void create() {
        String name = "책";
        BoardEntity board = new BoardEntity(name);

        assertThat(board.getBoardName()).isEqualTo(name);
    }

    @Test
    void change_name() {
        String name1 = "책";
        String name2 = "음악";
        BoardEntity board = new BoardEntity(name1);

        board.changeName(name2);

        assertThat(board.getBoardName()).isEqualTo(name2);
    }

}
