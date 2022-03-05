package com.example.week3.board.domain;

import com.example.week3.common.BaseEntity;
import com.example.week3.post.domain.PostEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String boardName;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private final List<PostEntity> posts = new ArrayList<>();

    protected BoardEntity() {
    }

    public BoardEntity(String boardName) {
        this.boardName = boardName;
    }

    public void addPost(PostEntity post) {
        this.posts.add(post);
        post.setBoard(this);
    }

    public Long getId() {
        return id;
    }

    public String getBoardName() {
        return boardName;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void changeName(String boardName) {
        this.boardName = boardName;
    }
}
