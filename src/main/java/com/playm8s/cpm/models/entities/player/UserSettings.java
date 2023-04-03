package com.playm8s.cpm.models.entities.player;

import com.playm8s.cpm.models.core.enums.DistanceLevel;
import com.playm8s.cpm.models.entities.common.Location;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSettings {

    String userId;

    int currentCity;
    DistanceLevel distanceLevel;

    Location location;
    public String get_id() {
        return userId;
    }
    public void set_id(String id) {
        this.userId = id;
    }

}
