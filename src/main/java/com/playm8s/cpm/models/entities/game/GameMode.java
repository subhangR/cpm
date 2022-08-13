package com.playm8s.cpm.models.entities.game;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game_modes")
@Data
public class GameMode {

    @Id
    @Column(name="game_mode_id")
    String gameModeId;

    String sportId;

    String name;

    @Column(name="num_players")
    int numOfPlayers;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */