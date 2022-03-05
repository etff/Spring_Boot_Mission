package com.example.week3.post.ui;

import com.example.week3.post.dto.PostRequest;
import com.example.week3.post.dto.PostResponse;
import com.example.week3.post.service.PostService;
import com.example.week3.user.domain.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create_post() throws Exception {
        PostRequest postRequest = new PostRequest(1L, "test", "hello world", "test1234");

        mockMvc.perform(
                        post("/boards/{id}/posts", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(postRequest))
                )
                .andExpect(status().isCreated());
    }

    @Test
    void get_post() throws Exception {
        UserEntity user = new UserEntity( "user1");
        PostResponse postResponse = new PostResponse(1L, "test1", "hello world", user);
        given(postService.getPost(anyLong()))
                .willReturn(postResponse);

        mockMvc.perform(
                        get("/posts/{id}", 1L)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(postResponse)));
    }

    @Test
    void change_post() throws Exception {
        PostRequest postRequest = new PostRequest(1L, "test2", "hello world2", "test1234");
        PostResponse postResponse = new PostResponse(4L, "test2", "hello world2", new UserEntity("user1"));
        given(postService.changePost(anyLong(), any(PostRequest.class)))
                .willReturn(postResponse);

        mockMvc.perform(
                        put("/posts/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(postRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().string(
                        objectMapper.writeValueAsString(postResponse))
                );
    }
}
