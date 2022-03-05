package com.example.week3.post.domain;

import com.example.week3.board.domain.BoardEntity;
import com.example.week3.common.BaseEntity;
import com.example.week3.user.domain.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    @Column(nullable = false, length = 20)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", foreignKey = @ForeignKey(name = "fk_post_to_board"))
    private BoardEntity board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", foreignKey = @ForeignKey(name = "fk_post_writer"))
    private UserEntity writer;

    protected PostEntity() {
    }

    public PostEntity(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public PostEntity(String title, String content, String password, UserEntity writer) {
        this.title = title;
        this.content = content;
        this.password = password;
        this.writer = writer;
    }

    public PostEntity writeBy(UserEntity writer) {
        this.writer = writer;
        return this;
    }

    public void setBoard(BoardEntity board) {
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public BoardEntity getBoard() {
        return board;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity getWriter() {
        return writer;
    }

    public void changeContent(PostEntity post) {
        if (!Objects.equals(this.writer, post.writer)) {
            throw new IllegalArgumentException();
        }
        if (!this.password.equals(post.getPassword())) {
            throw new IllegalArgumentException();
        }
        this.title = post.title;
        this.content = post.content;
    }
}
