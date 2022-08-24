package com.playm8s.cpm.services.matchmaking;

import com.playm8s.cpm.models.entities.court.CourtInventory;
import com.playm8s.cpm.models.entities.game.Lobby;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LobbyNode {
    Lobby lobby;
    int possibleCourtInventories;
}
