package com.example.mngkw_springboot.repository;

import com.example.mngkw_springboot.entity.Exercises;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExercisesRepository extends MongoRepository<Exercises, String> {
}
