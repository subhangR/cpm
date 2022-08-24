package com.playm8s.cpm.models.entities.game.modes;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game_modes")
@Data
@Getter
@Setter
@NoArgsConstructor
public class GameMode {

    @Id
    @Column(name="game_mode_id")
    String gameModeId;

    String sportId;

    String name;

    @Column(name="num_players")
    int numOfPlayers;

    String rules;

    String description;


}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */