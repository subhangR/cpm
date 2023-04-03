package com.playm8s.cpm.models.entities.court;

import com.playm8s.cpm.models.entities.common.Location;
import lombok.*;


import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Arena {
    public Arena(String arenaId, String name, Location location, String contactNumber, List<Court> courts) {
        this.arenaId = arenaId;
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
        this.courts = courts;
    }

    String arenaId;

    String name;

    Location location;

    String contactNumber;

    List<Court> courts;

     String get_id() {
        return arenaId;
    }

    public void set_id(String id) {
         this.arenaId = id;
    }

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */
