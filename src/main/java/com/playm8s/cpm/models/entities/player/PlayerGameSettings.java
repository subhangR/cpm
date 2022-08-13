package com.playm8s.cpm.models.entities.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player_game_settings")
public class PlayerGameSettings {


    @Id
    String playerGameSettingsId;

    @Column(name = "playerId")
    String playerId;

    @Column(name = "game_mode_id")
    String gameModeId;

//    @Column(name="preferred_courts")
//    String preferredCourts;
}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */