package com.team13.fantree.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostRequestDtoTest {

    private PostRequestDto postRequestDto;

    @BeforeEach
    void setUp() {
        postRequestDto = new PostRequestDto();
    }

    @Test
    @DisplayName("PostRequestDto Default Constructor Success")
    void testDefaultConstructor() {
        // Given
        // setUp()

        // When
        // @BeforeEach

        // Then
        assertThat(postRequestDto).isNotNull();
    }

    @Test
    @DisplayName("PostRequestDto Set Content Success")
    void testSetContent() {
        // Given
        String content = "RequestDto Unit Test";

        // When
        postRequestDto.setContent(content);

        // Then
        assertThat(postRequestDto.getContent()).isEqualTo(content);
    }
}
