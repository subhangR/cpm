package com.playm8s.cpm.models.entities.game;

import javax.persistence.Column;
import javax.persistence.Id;

public class Sport {
    @Id
    String id;

    @Column(name="name")
    String name;

    @Column(name="description")
    String description;

    @Column(name="rules")
    String rules;
}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */