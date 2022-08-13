package com.playm8s.cpm.models.entities.court;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="court_game_modes")
public class CourtGameMode {

    @Id
    String id;

    @Column(name="court_id")
    String courtId;

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