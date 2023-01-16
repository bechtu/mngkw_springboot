package com.example.mngkw_springboot.entity;


import com.example.mngkw_springboot.enums.Skills;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Data
public class Instructors {
    @MongoId
    private String id;
    private String name;
    private String surname;
    private String gender;
    private Integer age;
    private List<Skills> skills;

    public Instructors(String name, String surname, String gender, Integer age, List<Skills> skills) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.skills = skills;
    }
}
