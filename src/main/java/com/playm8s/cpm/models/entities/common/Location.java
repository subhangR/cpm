package com.playm8s.cpm.models.entities.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    String locationId;

    String name;

    Double latitude;

    Double longitude;
    public String get_id() {
        return locationId.toString();
    }

    public void set_id(String id) {
        this.locationId = id;
    }

    @JsonIgnore
    public String getCoordinatesAsString() {
        return latitude.toString() + "," + longitude.toString();
    }

    public double distance(Location location) {
        double theta = longitude - location.longitude;
        double dist = Math.sin(deg2rad(latitude)) * Math.sin(deg2rad(location.latitude)) + Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(location.latitude)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
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