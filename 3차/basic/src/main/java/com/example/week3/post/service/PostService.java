package com.example.week3.post.service;

import com.example.week3.board.domain.BoardEntity;
import com.example.week3.board.domain.BoardRepository;
import com.example.week3.post.domain.PostEntity;
import com.example.week3.post.domain.PostRepository;
import com.example.week3.post.dto.PostRequest;
import com.example.week3.post.dto.PostResponse;
import com.example.week3.user.domain.UserEntity;
import com.example.week3.user.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, BoardRepository boardRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public PostResponse createPost(Long boardId, PostRequest request) {
        BoardEntity foundBoard = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);
        UserEntity writer = userRepository.findById(request.getUserId())
                .orElseThrow(EntityNotFoundException::new);
        PostEntity post = new PostEntity(
                request.getTitle(),
                request.getContent(),
                request.getPassword(),
                writer
        );
        PostEntity saved = postRepository.save(post);
        foundBoard.addPost(saved);
        return new PostResponse(saved);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new PostResponse(post);
    }

    public Page<PostResponse> getPosts(PageRequest pageRequest) {
        Page<PostEntity> pages = postRepository.findAll(pageRequest);
        return pages.map(PostResponse::new);
    }

    public PostResponse changePost(Long postId, PostRequest request) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(EntityNotFoundException::new);
        UserEntity writer = userRepository.findById(request.getUserId())
                .orElseThrow(EntityNotFoundException::new);
        PostEntity updatedPost = request.getPost();
        updatedPost.writeBy(writer);
        post.changeContent(updatedPost);

        return new PostResponse(updatedPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
