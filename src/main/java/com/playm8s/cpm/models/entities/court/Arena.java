package com.playm8s.cpm.models.entities.court;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arenas")
public class Arena {

    @Id
    @Column(name="arena_id")
    String arenaId;

    String name;

    String locationId;

}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */
