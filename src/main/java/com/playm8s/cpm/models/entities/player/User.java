package com.playm8s.cpm.models.entities.player;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class User {

    String userId;

    String name;

    int age;

    int heightInInches;

    int weight;

    String phone;

    public User(String userId, String name, int age, int heightInInches, int weight, String phone) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.heightInInches = heightInInches;
        this.weight = weight;
        this.phone = phone;
    }

    public String get_id() {
        return userId;
    }

    public void set_id(String id) {
        this.userId = id;
    }
}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */