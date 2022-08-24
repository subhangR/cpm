package com.playm8s.cpm.models.entities.court;

import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.game.modes.GameMode;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Court {

    @Id
    @Column(name="court_id")
    String courtId;

    @Column(name="arena_id")
    String arenaId;

    @Column(name="sport_id")
    List<GameMode> supportedGameModes;

    @Column(name="name")
    String name;

    @Transient
    Location location;

}
/*
    CREATE TABLE courts(
        court_id text PRIMARY KEY    NOT NULL,
        arena_id  text   NOT NULL,
        location_id text NOT NULL
);
 */