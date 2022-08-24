package com.playm8s.cpm.models.entities.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lobby {

        String lobbyId;

        LobbyPlayer lobbyLeader;

        List<LobbyPlayer> lobbyPlayers;

        public int getPlayerCount() {
           if(lobbyLeader == null) return 0;
           return lobbyPlayers == null ?  0 : lobbyPlayers.size();
        }

}
