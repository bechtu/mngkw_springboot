package com.example.mngkw_springboot.entity;


import com.example.mngkw_springboot.enums.SpecificActivities;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document
@Data
public class Exercises {
    @MongoId
    private String id;
    private Instructors instructorId;
    private Camps campId;
    private SpecificActivities activity;
    private String start_time;

    public Exercises(Instructors instructorId, Camps campId, SpecificActivities activity, String start_time) {
        this.instructorId = instructorId;
        this.campId = campId;
        this.activity = activity;
        this.start_time = start_time;
    }
}
