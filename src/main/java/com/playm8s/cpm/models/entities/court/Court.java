package com.playm8s.cpm.models.entities.court;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courts")
public class Court {

    @Id
    @Column(name="court_id")
    String courtId;

    @Column(name="arena_id")
    String arenaId;

    @Column(name="sport_id")
    String sportId;

    @Column(name="name")
    String name;

}
/*
    CREATE TABLE courts(
        court_id text PRIMARY KEY    NOT NULL,
        arena_id  text   NOT NULL,
        location_id text NOT NULL
);
 */