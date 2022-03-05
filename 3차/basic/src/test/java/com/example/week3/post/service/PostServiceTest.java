package com.example.week3.post.service;

import com.example.week3.board.domain.BoardRepository;
import com.example.week3.post.domain.PostRepository;
import com.example.week3.post.dto.PostRequest;
import com.example.week3.post.dto.PostResponse;
import com.example.week3.user.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DataJpaTest
@Transactional
class PostServiceTest {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostService(postRepository, boardRepository, userRepository);
    }

    @Test
    void create_post() {
        Long boardId = 1L;
        PostRequest postRequest = new PostRequest(1L, "test1", "hello world", "test1234");

        assertDoesNotThrow(() -> postService.createPost(boardId, postRequest));
    }

    @Test
    void get_post() {
        Long boardId = 1L;
        PostRequest postRequest = new PostRequest(1L, "test1", "hello world", "test1234");
        PostResponse savedPost = postService.createPost(boardId, postRequest);

        PostResponse actual = postService.getPost(savedPost.getId());
        assertThat(actual).isEqualTo(savedPost);
    }

    @Test
    void get_posts() {
        PageRequest pageRequest = PageRequest.of(1,1);
        Page<PostResponse> posts = postService.getPosts(pageRequest);

        assertThat(posts.getTotalElements()).isEqualTo(2);
    }

    @Test
    void change_post() {
        Long boardId = 1L;
        String changeTitle = "test2";
        PostRequest postRequest = new PostRequest(1L, "test1", "hello world", "test1234");
        PostRequest postRequest2 = new PostRequest(1L, changeTitle, "hello world2", "test1234");
        PostResponse savedPost = postService.createPost(boardId, postRequest);

        PostResponse actual = postService.changePost(savedPost.getId(), postRequest2);

        assertThat(actual.getTitle()).isEqualTo(changeTitle);
    }
}
