package com.playm8s.cpm.models.entities.court;

import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.game.modes.GameMode;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Court {

    String courtId;

    String arenaId;

    List<GameMode> supportedGameModes;

    String name;

    Location location;

    public String get_id() {
        return courtId;
    }

    public void set_id(String id) {
        this.courtId = id;
    }


}
/*
    CREATE TABLE courts(
        court_id text PRIMARY KEY    NOT NULL,
        arena_id  text   NOT NULL,
        location_id text NOT NULL
);
 */