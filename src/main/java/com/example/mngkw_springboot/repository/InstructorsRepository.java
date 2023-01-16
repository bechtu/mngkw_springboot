package com.example.mngkw_springboot.repository;

import com.example.mngkw_springboot.entity.Instructors;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorsRepository extends MongoRepository<Instructors, String> {
}