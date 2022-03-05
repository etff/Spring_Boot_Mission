package com.example.week3.board.ui;

import com.example.week3.board.application.BoardService;
import com.example.week3.board.dto.BoardRequest;
import com.example.week3.board.dto.BoardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BoardService boardService;

    @Test
    void get_board() throws Exception {
        BoardResponse boardResponse = new BoardResponse(1L, "취미");
        given(boardService.getBoard(anyLong()))
                .willReturn(boardResponse);

        mockMvc.perform(
                        get("/boards/{id}", 1)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(boardResponse)));
    }

    @Test
    void get_board_list() throws Exception {
        BoardResponse boardResponse1 = new BoardResponse(1L, "취미");
        BoardResponse boardResponse2 = new BoardResponse(2L, "취미");
        List<BoardResponse> boards = List.of(boardResponse1, boardResponse2);
        given(boardService.getBoards())
                .willReturn(boards);

        mockMvc.perform(
                        get("/boards")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(boards)));
    }

    @Test
    void create_board() throws Exception {
        BoardRequest boardRequest = new BoardRequest("운동");
        BoardResponse boardResponse = new BoardResponse(4L);
        given(boardService.createBoard(any(BoardRequest.class)))
                .willReturn(boardResponse);

        mockMvc.perform(
                        post("/boards")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(boardRequest))
                )
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        objectMapper.writeValueAsString(boardResponse))
                );
    }

    @Test
    void change_board() throws Exception {
        BoardRequest boardRequest = new BoardRequest("개발");
        BoardResponse boardResponse = new BoardResponse(1L, "개발");
        given(boardService.changeBoard(anyLong(), any(BoardRequest.class)))
                .willReturn(boardResponse);

        mockMvc.perform(
                        put("/boards/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(boardRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().string(
                        objectMapper.writeValueAsString(boardResponse))
                );
    }

    @Test
    void delete_board() throws Exception {
        BoardResponse boardResponse = new BoardResponse(1L);
        given(boardService.deleteBoard(anyLong()))
                .willReturn(boardResponse);

        mockMvc.perform(
                        delete("/boards/{id}", 1L)
                )
                .andExpect(status().isNoContent());
    }
}
