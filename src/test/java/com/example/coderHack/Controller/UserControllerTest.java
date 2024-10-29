package com.example.coderHack.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.coderHack.Controllers.UserController;
import com.example.coderHack.Enitities.User;
import com.example.coderHack.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(123);
        user.setUsername("Anirudh");
        user.setScore(10);
        user.setBadges(List.of("Code Ninja"));
    }

    @Test
    void testRegisterUser() throws Exception {
        when(userService.registerUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("123"))
                .andExpect(jsonPath("$.username").value("Anirudh"));
    }

    @Test
    void testGetUserById() throws Exception {
        when(userService.getUserById(123)).thenReturn(user);

        mockMvc.perform(get("/users/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("Anirudh"));
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(user));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("Anirudh"));
    }

    @Test
    void testUpdateScore() throws Exception {
        when(userService.updateUserScore(123, 40)).thenReturn(user);

        mockMvc.perform(put("/users/123?score=40"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.score").value(10)); // Change as needed
    }

    @Test
    void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUser(123);

        mockMvc.perform(delete("/users/123"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetUserById_NotFound() throws Exception {
        when(userService.getUserById(999)).thenReturn(null);
    
        mockMvc.perform(get("/users/999"))
                .andExpect(status().isNotFound());
    }
    

}