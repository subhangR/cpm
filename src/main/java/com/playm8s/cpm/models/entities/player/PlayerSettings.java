package com.playm8s.cpm.models.entities.player;

import com.playm8s.cpm.models.core.enums.DistanceLevel;

import javax.persistence.*;

@Entity
@Table(name="player_settings")
public class PlayerSettings {

    @Id
    @Column(name="player_id")
    String playerId;

    @Column(name="current_city")
    int currentCity;

    @Column(name="distance_level")
    @Enumerated(EnumType.ORDINAL)
    DistanceLevel distanceLevel;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */