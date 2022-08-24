package com.playm8s.cpm.models.entities.court;

import com.playm8s.cpm.models.entities.common.Location;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Arena {

    @Id
    String arenaId;

    String name;

    Location locationId;

    String contactNumber;

    List<Court> courts;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */
