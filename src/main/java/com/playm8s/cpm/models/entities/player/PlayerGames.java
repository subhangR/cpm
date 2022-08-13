package com.playm8s.cpm.models.entities.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player_games")
public class PlayerGames {

    @Id
    @Column(name="game_id")
    String gameId;

    @Column(name="player_id")
    String playerId;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */