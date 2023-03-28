package com.playm8s.cpm.models.entities.player;

import com.playm8s.cpm.models.core.enums.DistanceLevel;
import com.playm8s.cpm.models.entities.common.Location;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSettings {

    String playerId;

    int currentCity;

    DistanceLevel distanceLevel;

    Location location;

}
