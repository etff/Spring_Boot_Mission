package com.example.week3.post.ui;

import com.example.week3.board.dto.BoardRequest;
import com.example.week3.board.dto.BoardResponse;
import com.example.week3.post.dto.PostRequest;
import com.example.week3.post.dto.PostResponse;
import com.example.week3.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/boards/{boardId}/posts")
    public ResponseEntity<PostResponse> createPost(@PathVariable Long boardId, @RequestBody PostRequest request) {
        PostResponse post = postService.createPost(boardId, request);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        PostResponse postResponse = postService.getPost(id);
        return ResponseEntity.ok().body(postResponse);
    }

    @GetMapping("/posts")
    public ResponseEntity<Page<PostResponse>> getPosts(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<PostResponse> posts = postService.getPosts(pageRequest);
        return ResponseEntity.ok().body(posts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> changePost(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        PostResponse postResponse = postService.changePost(id, postRequest);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
