package com.team13.fantree.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    private User user;

    // BeforeEach
    @BeforeEach
    void SetUser() {
        user = new User(
                "hyun",
                "1234qwer",
                "oneMinute",
                "test@email.com",
                "HelloUnitTest"
        );
    }

    // constructor - create
    @Test
    @DisplayName("User Create Success")
    void test1() {
        // Given
        // setUser()

        // When
        // @BeforeEach

        // Then
        assertThat(user.getUsername()).isEqualTo("hyun");
        assertThat(user.getPassword()).isEqualTo("1234qwer");
        assertThat(user.getName()).isEqualTo("oneMinute");
        assertThat(user.getEmail()).isEqualTo("test@email.com");
        assertThat(user.getHeadline()).isEqualTo("HelloUnitTest");
        assertThat(user.getStatus()).isEqualTo(UserStatusEnum.NOAUTH_USER);
        assertNull(user.getRefreshToken());
    }

    // withDraw
    @Test
    @DisplayName("User WithDraw Success (User -> NON_USER)")
    void test2() {
        // Given
        // NotThing

        // When
        user.withDraw();

        // Then
        assertThat(user.getStatus()).isEqualTo(UserStatusEnum.NON_USER);
        assertThat(user.getStatusUpdate()).isEqualTo(user.getModifiedAt());
        assertNull(user.getRefreshToken());
    }


    // logout
    @Test
    @DisplayName("User Logout Success")
    void test3() {
        // Given
        // NotThing

        // When
        user.logout();

        // Then
        assertNull(user.getRefreshToken());
    }

    // update - no name
    @Test
    @DisplayName("User Update Success")
    void test4() {
        // Given
        String headline = "UpdateUnitTest";
        String password = "qwer1234";

        // When
        user.update(Optional.empty(), Optional.of(headline), Optional.of(password));

        // Then
        assertThat(user.getName()).isEqualTo("oneMinute");
        assertThat(user.getHeadline()).isEqualTo("UpdateUnitTest");
        assertThat(user.getPassword()).isEqualTo("qwer1234");
    }

    // userStatusUpdate
    @Test
    @DisplayName("User UserStatusUpdate Success (NOAUTH_USER -> USER)")
    void test5() {
        // Given
        // NotThing

        // When
        user.userStatusUpdate();

        // Then
        assertThat(user.getStatus()).isEqualTo(UserStatusEnum.USER);
        assertThat(user.getStatusUpdate()).isEqualTo(user.getModifiedAt());
    }

    // saveRefreshToken
    @Test
    @DisplayName("SaveRefreshToken Success")
    void test6() {
        // Given
        String refreshToken = "RefreshToken";

        // When
        user.saveRefreshToken(refreshToken);

        // Then
        assertEquals(refreshToken, user.getRefreshToken());
    }

}
