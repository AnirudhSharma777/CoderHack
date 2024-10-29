package com.example.coderHack.Enitities;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class UserTest {

    @Test
    void testUserEntity() {
        // Create user using constructor
        User user = new User();
        user.setUserId(1);
        user.setUsername("Anirudh");
        user.setScore(10);
        user.setBadges(List.of("Code Ninja"));

        // Validate initial state
        assertThat(user.getUserId()).isEqualTo(1);
        assertThat(user.getUsername()).isEqualTo("Anirudh");
        assertThat(user.getScore()).isEqualTo(10);
        assertThat(user.getBadges()).contains("Code Ninja");

        // Modify user with setters
        user.setScore(30);
        user.setBadges(List.of("Code Champ"));

        // Validate changes
        assertThat(user.getScore()).isEqualTo(30);
        assertThat(user.getBadges()).contains("Code Champ");
    }
}