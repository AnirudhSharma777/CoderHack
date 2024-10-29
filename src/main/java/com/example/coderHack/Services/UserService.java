package com.example.coderHack.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coderHack.Enitities.User;
import com.example.coderHack.Repositories.UserRepository;

@Service
public class UserService {

     @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAllByOrderByScoreDesc();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User registerUser(User user) {
        if (userRepository.existsById(user.getUserId())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User updateUserScore(Integer userId, int newScore) {
        if (newScore < 0 || newScore > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        User user = getUserById(userId);
        user.setScore(newScore);
        user.updateBadges();
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }
}
