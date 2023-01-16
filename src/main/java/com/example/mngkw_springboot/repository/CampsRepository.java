package com.example.mngkw_springboot.repository;

import com.example.mngkw_springboot.entity.Camps;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampsRepository extends MongoRepository<Camps, String> {
}
