package com.playm8s.cpm.models.entities.common;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@Data
public class Location {

    @Id
    @Column(name="id")
    String locationId;

    @Column(name="name")
    String name;

    @Column(name="latitude")
    Double latitude;

    @Column(name="longitude")
    Double longitude;

}
/*
    CREATE TABLE locations(
        location_id text PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        latitude double NOT NULL,
        longitude double NOT NULL
);
 */