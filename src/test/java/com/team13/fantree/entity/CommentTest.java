package com.team13.fantree.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentTest {

    private Comment comment;
    private Post post;
    private User user;

    // BeforeEach
    @BeforeEach
    void SetComment() {
        comment = new Comment(
                SetPost(),
                SetUser(),
                "CommentUnitTest"
        );
    }

    private Post SetPost() {
        post = new Post(
                "PostUnitTest",
                SetUser()
        );

        return post;
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
    @DisplayName("Comment Create Success")
    void test1() {
        // Given
        // setComment()

        // When
        // @BeforeEach

        // Then
        assertThat(comment.getContent()).isEqualTo("CommentUnitTest");
        assertThat(comment.getUser()).isEqualTo(user);
        assertThat(comment.getLikeCount()).isEqualTo(0L);
    }

    // setContent - modifiedAt NotNull 테스트는 모킹해서 못하는거였네 ㅎㅎ
    @Test
    @DisplayName("Comment Update Success")
    void test2() {
        // Given
        String content = "Comment Entity Test";

        // When
        comment.setContent(content);

        // Then
        assertThat(comment.getContent()).isEqualTo("Comment Entity Test");
    }

    // UpLikeCount
    @Test
    @DisplayName("Up Like Count Success")
    void test3() {
        // Given
        // NotThing

        // When
        comment.UpLikeCount();

        // Then
        assertThat(comment.getLikeCount()).isEqualTo(1L);
    }

}
