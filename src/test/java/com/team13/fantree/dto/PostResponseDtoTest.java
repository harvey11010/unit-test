package com.team13.fantree.dto;

import com.team13.fantree.entity.Post;
import com.team13.fantree.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostResponseDtoTest {

    private Post post;

    @BeforeEach
    void SetPost() {
        post = new Post(
                "PostUnitTest",
                SetUser()
        );
    }

    private User SetUser() {
        return new User(
                "hyun",
                "1234qwer",
                "oneMinute",
                "test@email.com",
                "HelloUnitTest"
        );
    }

    @Test
    @DisplayName("PostResponseDto Initialization Success")
    void testPostResponseDtoInitialization() {
        // Given
        // setPost()

        // When
        PostResponseDto postResponseDto = new PostResponseDto(post);

        // Then
        assertThat(postResponseDto.getId()).isEqualTo(post.getId());
        assertThat(postResponseDto.getUsername()).isEqualTo(post.getUser().getUsername());
        assertThat(postResponseDto.getContent()).isEqualTo(post.getContent());
        assertThat(postResponseDto.getLikeCount()).isEqualTo(post.getLikeCount());
    }
}
