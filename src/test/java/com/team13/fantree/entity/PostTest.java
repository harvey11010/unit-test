package com.team13.fantree.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    private Post post;
    private User user;

    // BeforeEach
    @BeforeEach
    void SetPost() {
        post = new Post(
                "PostUnitTest",
                SetUser()
        );
    }

    private User SetUser() {
        user = new User(
                "hyun",
                "1234qwer",
                "oneMinute",
                "test@email.com",
                "HelloUnitTest"
        );

        return user;
    }

    // constructor - create
    @Test
    @DisplayName("Post Create Success")
    void test1() {
        // Given
        // setPost()

        // When
        // @BeforeEach

        // Then
        assertThat(post.getContent()).isEqualTo("PostUnitTest");
        assertThat(post.getUser()).isEqualTo(user);
        assertThat(post.getLikeCount()).isEqualTo(0L);
    }

    // setContent - 왜 update 가 아니지? - UserTest 에서 modifiedAt NotNull 테스트를 안했네 ㅎㅎ
    @Test
    @DisplayName("Post Update Success")
    void test2() {
        // Given
        String content = "Post Entity Test";

        // When
        post.setContent(content);

        // Then
        assertThat(post.getContent()).isEqualTo("Post Entity Test");
    }

    // UpLikeCount - 왜 대문자 시작이지?
    @Test
    @DisplayName("Up Like Count Success")
    void test3() {
        // Given
        // NotThing

        // When
        post.UpLikeCount();

        // Then
        assertThat(post.getLikeCount()).isEqualTo(1L);
    }

}
