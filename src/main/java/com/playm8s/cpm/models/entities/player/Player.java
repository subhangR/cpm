package com.playm8s.cpm.models.entities.player;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "player_id")
    String playerId;

    @JsonProperty(value = "name")
    String name;

    @JsonProperty(value = "age")
    int age;

    @JsonProperty(value = "height_in_inches")
    @Column(name="height_in_inches")
    int heightInInches;

    @JsonProperty(value = "weight")
    int weight;

    @JsonProperty(value = "phone")
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