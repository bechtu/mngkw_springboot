package com.example.mngkw_springboot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document
@Data
public class Camps {
    @MongoId
    private String id;
    private String camp_name;
    private String turnout;

    public Camps(String camp_name, String turnout) {
        this.camp_name = camp_name;
        this.turnout = turnout;
    }
}
