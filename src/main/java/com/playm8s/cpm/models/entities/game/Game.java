package com.playm8s.cpm.models.entities.game;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "games")
@Data
public class Game {

    @Id
    @Column(name="game_id")
    String gameId;

    @Column(name="court_id")
    String courtId;

    @Column(name="start_time")
    Timestamp startTime;

    @Column(name="end_time")
    Timestamp endTime;

    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    GameStatus status;

    @Column(name="game_mode_id")
    String gameModeId;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */