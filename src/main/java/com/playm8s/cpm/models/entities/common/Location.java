package com.playm8s.cpm.models.entities.common;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    public Location(Double latitude,Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    @Id
    @Column(name="id")
    String locationId;

    @Column(name="name")
    String name;

    @Column(name="latitude")
    Double latitude;

    @Column(name="longitude")
    Double longitude;



    public String getCoordinatesAsString() {
        return latitude.toString() + "," + longitude.toString();
    }

}
/*
    CREATE TABLE locations(
        location_id text PRIMARY KEY    NOT NULL,
        name  text   NOT NULL,
        latitude double NOT NULL,
        longitude double NOT NULL
);
 */