package com.playm8s.cpm.models.entities.game.modes;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameMode {

    String gameModeId;

    String sportId;

    String name;

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