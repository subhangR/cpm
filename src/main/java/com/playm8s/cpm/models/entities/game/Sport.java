package com.playm8s.cpm.models.entities.game;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
@Data
@Getter
@Setter
@NoArgsConstructor
public class Sport {

    String id;

    String name;

    String description;

    String rules;
}
/*
    CREATE TABLE arenas(
        arena_id INT PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        location_id text NOT NULL
);
 */