package com.example.week3.post.domain;

import com.example.week3.user.domain.UserEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PostEntityTest {

    @Test
    void create() {
        PostEntity postEntity = new PostEntity("test1", "hello world", "test1234");
        assertThat(postEntity).isNotNull();
    }

    @Test
    void changeContent() {
        UserEntity user = new UserEntity(1L, "user1");
        PostEntity postEntity = new PostEntity("test1", "hello world", "test1234", user);
        String changedContent = "hello world2";
        String changedTitle = "test2";
        PostEntity changeContent = new PostEntity(changedTitle, changedContent, "test1234", user);

        postEntity.changeContent(changeContent);

        assertAll(() -> {
            assertThat(postEntity.getTitle()).isEqualTo(changedTitle);
            assertThat(postEntity.getContent()).isEqualTo(changedContent);
        });


    }

}
