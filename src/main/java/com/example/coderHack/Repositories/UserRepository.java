package com.example.coderHack.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.coderHack.Enitities.User;

public interface UserRepository extends MongoRepository<User,Integer>{
    List<User> findAllByOrderByScoreDesc();
}
