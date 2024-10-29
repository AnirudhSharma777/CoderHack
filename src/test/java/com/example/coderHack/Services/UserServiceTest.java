package com.example.coderHack.Services;

import com.example.coderHack.Enitities.User;
import com.example.coderHack.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserId(1);
        user.setScore(50);
    }

    @Test
    void testUpdateUserScore_Success() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User updatedUser = userService.updateUserScore(1, 75);

        // Assert
        assertEquals(75, updatedUser.getScore());
        verify(userRepository).save(user);
    }

    @Test
    void testUpdateUserScore_UserNotFound() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.updateUserScore(1, 75);
        });
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void testUpdateUserScore_InvalidScore() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUserScore(1, -10);
        });
        assertEquals("Score must be between 0 and 100", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUserScore(1, 110);
        });
        assertEquals("Score must be between 0 and 100", exception.getMessage());
    }
}