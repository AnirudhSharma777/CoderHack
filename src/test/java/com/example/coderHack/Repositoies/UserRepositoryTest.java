package com.example.coderHack.Repositoies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.example.coderHack.Enitities.User;
import com.example.coderHack.Repositories.UserRepository;


@DataMongoTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        userRepository.deleteAll();
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUserId(123);
        user.setUsername("Anirudh");
        user.setScore(10);

        User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserId()).isEqualTo(123);
        assertThat(savedUser.getUsername()).isEqualTo("Anirudh");
        assertThat(savedUser.getScore()).isEqualTo(10);
    }

     @Test
    void testFindUserById() {
        User user = new User();
        user.setUserId(124);
        user.setUsername("Rohan");
        userRepository.save(user);

        Optional<User> retrievedUser = userRepository.findById(124);

        assertThat(retrievedUser).isPresent();
        assertThat(retrievedUser.get().getUsername()).isEqualTo("Rohan");
    }

    @Test
    void testFindAllByOrderByScoreDesc() {
        User user1 = new User();
        user1.setUserId(125);
        user1.setUsername("Alice");
        user1.setScore(30);

        User user2 = new User();
        user2.setUserId(126);
        user2.setUsername("Bob");
        user2.setScore(50);

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> users = userRepository.findAllByOrderByScoreDesc();

        assertThat(users).hasSize(2);
        assertThat(users.get(0).getUsername()).isEqualTo("Bob");
        assertThat(users.get(1).getUsername()).isEqualTo("Alice");
    }

    @Test
    void testDeleteUser() {
        User user = new User();
        user.setUserId(127);
        user.setUsername("Charlie");
        userRepository.save(user);

        userRepository.deleteById(127);
        Optional<User> retrievedUser = userRepository.findById(127);

        assertThat(retrievedUser).isEmpty();
    }

}
