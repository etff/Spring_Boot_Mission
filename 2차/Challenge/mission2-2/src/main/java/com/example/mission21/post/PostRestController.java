package com.example.mission21.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createPost(@RequestBody Post post) {
        logger.info(post.toString());
        this.postService.createPost(post);
    }

    @GetMapping("{id}")
    public Post readPostOne(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("{id}")
    public void updatePost(
            @RequestBody Post post,
            @PathVariable("id") int id) {
        logger.info("target id: " + id);
        logger.info("update content" + post);
        this.postService.updatePost(id, post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}
