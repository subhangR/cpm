package com.playm8s.cpm.models.entities.player;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
@Data
public class Player {

    @Id
    @Column(name = "player_id")
    String playerId;

    String name;

    int age;

    @Column(name="height_in_inches")
    int heightInInches;

    int weight;

    @Column(name="phone")
    String phone;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */